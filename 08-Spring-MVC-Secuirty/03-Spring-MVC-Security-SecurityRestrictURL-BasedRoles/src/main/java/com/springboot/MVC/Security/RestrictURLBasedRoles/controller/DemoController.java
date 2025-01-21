package com.springboot.MVC.Security.RestrictURLBasedRoles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showDashboard(Model theModel) {
        LocalDateTime theDateTime = LocalDateTime.now();
        theModel.addAttribute("datetime",theDateTime);
        return "dashboard";
    }

    @GetMapping("/manager")
    public String showManagerPage() {
        return "Manager-Access-Page";
    }

    @GetMapping("/admin")
    public String showAdminPage() {
        return "Admin-Access-Page";
    }
}
