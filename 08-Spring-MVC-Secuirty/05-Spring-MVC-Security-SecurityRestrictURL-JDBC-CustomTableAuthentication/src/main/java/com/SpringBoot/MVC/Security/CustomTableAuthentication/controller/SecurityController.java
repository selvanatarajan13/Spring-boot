package com.SpringBoot.MVC.Security.CustomTableAuthentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "custom-login-page";
    }
}
