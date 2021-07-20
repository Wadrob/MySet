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
// TODO Warto mieć 1 kontroler -> 1 widok
public class HomePageController {

    private final AuthenticationService authenticationService;

    public HomePageController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    // TODO To jest zadanie Spring Security, aby ze strony głównej (?) "/" szło zawsze na "/login"
    @GetMapping("/")
    public String toLoginPage(){
        return "redirect:/collection/show";
    }

    // TODO W LoginPageController
    @GetMapping("/login")
    public String userLoginPage(){
        return "homepage/login-page";
    }

    // TODO W RegistrationPageController
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
