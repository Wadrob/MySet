package com.github.wadrob.myset.web.controllers;

import com.github.wadrob.myset.domain.model.User;
import com.github.wadrob.myset.domain.service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class HomePageController {

    private final AuthenticationService authenticationService;

    public HomePageController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/")
    public String toLoginPage(){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String userLoginPage(){
        return "homepage/login-page";
    }

    @GetMapping("/register")
    public String prepareRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "/homepage/registration-form";
    }

    @PostMapping("/register")
    public String processRegistationPage(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/homepage/registration-form";
        }
        authenticationService.registerUser(user);
        return "redirect:/login";
    }
}
