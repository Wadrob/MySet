package com.github.wadrob.myset.web.controllers;

import com.github.wadrob.myset.domain.model.Collection;
import com.github.wadrob.myset.domain.model.User;
import com.github.wadrob.myset.domain.repository.CollectionRepository;
import com.github.wadrob.myset.domain.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CollectionControler {

    private final CollectionRepository collectionRepository;
    private final UserRepository userRepository;

    public CollectionControler(CollectionRepository collectionRepository, UserRepository userRepository) {
        this.collectionRepository = collectionRepository;
        this.userRepository = userRepository;
    }

    @ModelAttribute
    public User getUser(){
        return new User();
    }

    @GetMapping("/collection/{id}")
    public String CollectionMainPage(Model model, @PathVariable Long id){
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        model.addAttribute("collections", collectionRepository.findAllByUser(user));
        return "collection/collection-main-page";
    }

    @GetMapping("/collection/add")
    public String toForm(Model model){
        model.addAttribute("collection", new Collection());
        return "collection/collection-add-form";
    }

    @PostMapping("/collection/add")
    public String takeForm(Collection collection){
        collectionRepository.save(collection);
        return "redirect:/collection/1";
    }
}
