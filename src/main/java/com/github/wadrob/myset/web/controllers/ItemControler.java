package com.github.wadrob.myset.web.controllers;

import com.github.wadrob.myset.domain.model.Item;
import com.github.wadrob.myset.domain.repository.CollectionRepository;
import com.github.wadrob.myset.domain.repository.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ("/items")
public class ItemControler {

    private final ItemRepository itemRepository;
    private final CollectionRepository collectionRepository;

    public ItemControler(ItemRepository itemRepository, CollectionRepository collectionRepository) {
        this.itemRepository = itemRepository;
        this.collectionRepository = collectionRepository;
    }

    @GetMapping("/add")
    public String beforeForm(Model model, @RequestParam Long id){
        model.addAttribute("colId", id);
        model.addAttribute("item", new Item());
        return "items/item-add-form";
    }

    @PostMapping("/add")
    public String afteAdd(Item item, @RequestParam Long colId){
        item.setCollection(collectionRepository.findById(colId).get());
        itemRepository.save(item);
        return "redirect:/collection/show";
    }

    @GetMapping("/edit")
    public String beforeEditForm (@RequestParam Long id, Model model){
        model.addAttribute("item", itemRepository.findById(id).get());
        return "items/item-edit-form";
    }

    @PostMapping("/edit")
    public String afterEditForm(Item item){
        itemRepository.save(item);
        return "redirect:/collection/show";
    }

    @GetMapping("/delete")
    public String deleteItem(@RequestParam Long colId, @RequestParam Long id){
        itemRepository.deleteById(id);
        return "redirect:/collection/showItems/" + colId;
    }



}
