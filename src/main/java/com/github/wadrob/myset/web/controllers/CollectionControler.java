package com.github.wadrob.myset.web.controllers;

import com.github.wadrob.myset.domain.model.Collection;
import com.github.wadrob.myset.domain.model.User;
import com.github.wadrob.myset.domain.repository.CollectionRepository;
import com.github.wadrob.myset.domain.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/collection")
public class CollectionControler {

    private final CollectionRepository collectionRepository;
    private final UserRepository userRepository;

    public CollectionControler(CollectionRepository collectionRepository, UserRepository userRepository) {
        this.collectionRepository = collectionRepository;
        this.userRepository = userRepository;
    }

    @ModelAttribute
    private User user(){
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(userEmail).get();
    }

    @GetMapping("/show")
    public String CollectionMainPage(Model model){
        model.addAttribute("collections", collectionRepository.findAllByUser(user()));
        return "collection/collection-main-page";
    }

    @GetMapping("/add")
    public String beforeCreateForm(Model model){
        model.addAttribute("collection", new Collection());
        return "collection/collection-add-form";
    }

    @PostMapping("/add")
    public String afterCreateForm(@Valid Collection collection, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "collection/collection-add-form";
        }
        collection.setUser(user());
        collectionRepository.save(collection);
        return "redirect:/collection/show";
    }

    @GetMapping("/edit")
    public String beforeEditForm (Model model, @RequestParam Long id){
        model.addAttribute("collectionEdit", collectionRepository.findById(id).get());
        model.addAttribute("items", collectionRepository.findById(id).get().getItems());
        return "collection/collection-edit-form";
    }

    @PostMapping("/edit")
    public String afterEditForm(@Valid Collection collection,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "collection/collection-edit-form";
        }
        collection.setUser(user());
        collectionRepository.save(collection);
        return "redirect:/collection/show";
    }

    @GetMapping("/delete")
    public String deleteCollection(Model model, @RequestParam Long id){
        model.addAttribute("collectionToDelete", collectionRepository.findById(id).get());
        return "collection/collection-delete-confirmation";
    }

    @GetMapping("/delete/{id}")
    public String deleteAfterConfirmation(@PathVariable Long id){
        collectionRepository.deleteById(id);
        return "redirect:/collection/show";
    }

}
