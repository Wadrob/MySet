package com.github.wadrob.myset.web.controllers;

import com.github.wadrob.myset.domain.model.Item;
import com.github.wadrob.myset.domain.model.Tag;
import com.github.wadrob.myset.domain.repository.ItemRepository;
import com.github.wadrob.myset.domain.repository.TagRepository;
import com.github.wadrob.myset.domain.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
@RequestMapping("/tags")
public class TagController {

    private final TagRepository tagRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public TagController(TagRepository tagRepository, ItemRepository itemRepository, UserRepository userRepository) {
        this.tagRepository = tagRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/addTag")
    public String addNewTagsFromItem(Model model, @RequestParam Long itemId){
        model.addAttribute("item", itemRepository.findById(itemId).get());
        model.addAttribute("tagsList", tagRepository.findAll());
        model.addAttribute("tag", new Tag());
        return "/tags/add-new-tag-from-item";
    }

    @PostMapping("/addTag")
    public String addNewTagsAfterForm(Item item){
        itemRepository.save(item);
        return "redirect:/items/showItems/" + item.getCollection().getId();
    }

    @GetMapping("/addNewTag")
    public String addNewTag(Model model, @RequestParam Long userId){
        model.addAttribute("Tag", new Tag());
        model.addAttribute("user", userId);
        return "/tags/add-new-tag";
    }

    @PostMapping("/addNewTag")
    public String addNewTagAfterForm(@Valid Tag tag, BindingResult bindingResult, @RequestParam Long user){
        if(bindingResult.hasErrors()){
            return "/tags/add-new-tag";
        }
        tag.setUser(userRepository.findById(user).get());
        tagRepository.save(tag);
        return "redirect:/tags/showAllTags?userId="+ userRepository.findById(user).get().getId();
    }

    @GetMapping("/showAllTags")
    public String showAllTags(Model model, @RequestParam Long userId){
        model.addAttribute("tags", tagRepository.findAllByUser(userRepository.findById(userId).get()));
        model.addAttribute("user", userRepository.findById(userId).get());
        return "/tags/show-all-tags-page";
    }

    @GetMapping("/deleteItem")
    public String deleteTags(@RequestParam Long tagId){
        Long userId = tagRepository.findById(tagId).get().getUser().getId();
        tagRepository.deleteById(tagId);
        return "redirect:/tags/showAllTags?userId=" + userId;
    }
}
