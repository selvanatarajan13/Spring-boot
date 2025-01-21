package com.SpringBoot.MVC.SecurityCustom.controller;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableWebSecurity
public class SecurityController {

    @GetMapping("/showLoginPage")
    public String demo() {
        return "plain-login";
    }
}
