package com.springboot.MVC.Security.RestrictURLBasedRoles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {


    @GetMapping("/login")
    public String showLoginPage() {
        return "custom-loginpage";
    }

    @GetMapping("/403-Access-Denied")
    public String showAccessDeniedPage() {
        return "Custom-Access-Denied-Page";
    }
}
