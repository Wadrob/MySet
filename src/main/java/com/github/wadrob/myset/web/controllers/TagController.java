package com.github.wadrob.myset.web.controllers;

import com.github.wadrob.myset.domain.repository.TagRepository;
import org.springframework.stereotype.Controller;

@Controller
public class TagController {

    private final TagRepository tagRepository;

    public TagController(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public String addNewTag(){

    }
}
