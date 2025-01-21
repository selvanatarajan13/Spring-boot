package com.SpringBoot.Security.InmemoryAuthentication.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoRestController {

    @GetMapping("/home")
    public String home() {
        return "Home page.";
    }

    @GetMapping("/user/home")
    public String userHome() {
        return "User";
    }

    @GetMapping("/admin/home")
    public String adminHome() {
        return "Admin";
    }

    @GetMapping("/403-Access-Denied")
    public String accessDenied() {
        return "403-Access-Denied";
    }
}
