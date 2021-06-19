package com.github.wadrob.myset.web.controllers;

import com.github.wadrob.myset.domain.model.Collection;
import com.github.wadrob.myset.domain.model.Item;
import com.github.wadrob.myset.domain.repository.CollectionRepository;
import com.github.wadrob.myset.domain.repository.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping ("/items")
public class ItemControler {

    private final ItemRepository itemRepository;
    private final CollectionRepository collectionRepository;

    public ItemControler(ItemRepository itemRepository, CollectionRepository collectionRepository) {
        this.itemRepository = itemRepository;
        this.collectionRepository = collectionRepository;
    }

    @ModelAttribute("statuses")
    public List<String> itemStatus (){
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
    public String afteAdd(Item item, @RequestParam Long colId){
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
    public String afterEditForm(Item item){
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
        Map<String, List<Item>> sortedCollection = mapByStatus(collectionRepository.findById(id).get());
        model.addAttribute("itemCollection", sortedCollection);
        model.addAttribute("collectionId", id);
        model.addAttribute("items", collectionRepository.findById(id).get().getItems());
        return "collection/collection-show-items";
    }

    public Map <String,List<Item>> mapByStatus(Collection collection){
        List<Item> collectionItems = itemRepository.findAllByCollection(collection);
        Map<String, List<Item>> mappedCollection = new HashMap<>();
        Comparator<Item> compareByStatus = Comparator.comparing(Item::getStatus);
        collectionItems.sort(compareByStatus);
        List<Item> toAdd = new ArrayList<>();

        for (int i = 0; i < collectionItems.size(); i++){
            String i1 = collectionItems.get(i).getStatus();
            String i2;


            if (i+1 >= collectionItems.size()){
                toAdd.add(collectionItems.get(i));
                mappedCollection.put(i1, toAdd);
            }
            else {
                i2 = collectionItems.get(i+1).getStatus();
                if (i1.equals(i2)){
                    toAdd.add(collectionItems.get(i));
                }
                else {
                    toAdd.add(collectionItems.get(i));
                    mappedCollection.put(i1, toAdd);
                    toAdd = new ArrayList<>();
                }
            }
        }
        return mappedCollection;
    }







}
