package com.github.wadrob.myset.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoggingPageController {

    @GetMapping("/")
    public String userLoginPage(){
        return "login/login-page";
    }
}
