package com.github.wadrob.myset.web.controllers;

import com.github.wadrob.myset.domain.model.Item;
import com.github.wadrob.myset.domain.repository.CollectionRepository;
import com.github.wadrob.myset.domain.repository.ItemRepository;
import com.github.wadrob.myset.domain.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping ("/items")
// TODO Kontroler w stylu REST (jeden kontroler do wielu akcji), zamiast wiele kontrolerów
//      w stylu MVC (jeden kontroler do jednego widoku)
public class ItemController {

    private final ItemRepository itemRepository;
    private final CollectionRepository collectionRepository;
    private final ItemService itemService;

    public ItemController(ItemRepository itemRepository, CollectionRepository collectionRepository, ItemService itemService) {
        this.itemRepository = itemRepository;
        this.collectionRepository = collectionRepository;
        this.itemService = itemService;
    }

    // TODO Przy jednym kontrolerze ten model jest wypełniany zawsze
    //      czy przy usuwaniu potrzeba listy statusów?
    @ModelAttribute("statuses")
    public List<String> itemStatus (){
        // TODO Taką listę trzeba przenieść na bazę danych, aby dało się ją konfigurować.
        //      Jeżeli statusu są na sztywno ustalone i nie może być innych to Enum
        List<String> status = new ArrayList<>();
        status.add("Owned");
        status.add("To buy");
        status.add("Waiting for release");
        status.add("Pre-ordered");
        status.add("In shop");
        return status;
    }

    @GetMapping("/add")
    public String beforeForm(Model model, @RequestParam Long colId){
        model.addAttribute("colId", colId);
        model.addAttribute("item", new Item());
        return "items/item-add-form";
    }

    @PostMapping("/add")
    public String afterAdd(@Valid Item item, BindingResult bindingResult, @RequestParam Long colId){
        if(bindingResult.hasErrors()){
            return "items/item-add-form";
        }
        // TODO Wykorzystanie Optional z pominięciem tego, że to ... optional ;)
        //      id może nie istnieć.
        // TODO Zmieniając id kolekcji (colId), na id cudzej kolekcji,
        //      dodam item komuś innemu, np. item o nazwie "Twoja mama..."
        //      Zamiast findById -> findByIdAndUserEmail
        item.setCollection(collectionRepository.findById(colId).get());
        itemRepository.save(item);
        return "redirect:/items/showItems/" + colId;
    }

    @GetMapping("/edit")
    public String beforeEditForm (@RequestParam Long id, Model model){
        model.addAttribute("item", itemRepository.findById(id).get());
        return "items/item-edit-form";
    }

    @PostMapping("/edit")
    public String afterEditForm(@Valid Item item, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "items/item-edit-form";
        }
        itemRepository.save(item);
        Long colId = item.getCollection().getId();
        return "redirect:/items/showItems/" + colId ;
    }

    @GetMapping("/delete")
    public String deleteItem(@RequestParam Long colId, @RequestParam Long id){
        itemRepository.deleteById(id);
        return "redirect:/items/showItems/" + colId;
    }

    @GetMapping("/showItems/{id}")
    public  String showItemsForCollection(Model model, @PathVariable Long id){
        Map<String, List<Item>> sortedCollection = itemService.mapByStatus(collectionRepository.findById(id).get());
        model.addAttribute("itemCollection", sortedCollection);
        model.addAttribute("collectionId", id);
        model.addAttribute("items", collectionRepository.findById(id).get().getItems());
        return "collection/collection-show-items";
    }

    @GetMapping("/showTagForItem/{id}")
    public String showTagsForItem(Model model, @PathVariable Long id){
        model.addAttribute("item", itemRepository.findById(id).get());
        return "items/item-show-tags-page";
    }

}
