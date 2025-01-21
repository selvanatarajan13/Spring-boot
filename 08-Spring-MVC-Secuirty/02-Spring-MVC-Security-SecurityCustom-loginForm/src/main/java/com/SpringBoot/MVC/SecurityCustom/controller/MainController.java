package com.SpringBoot.MVC.SecurityCustom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String showLandingPage() {
        return "welcome-page";
    }
}
