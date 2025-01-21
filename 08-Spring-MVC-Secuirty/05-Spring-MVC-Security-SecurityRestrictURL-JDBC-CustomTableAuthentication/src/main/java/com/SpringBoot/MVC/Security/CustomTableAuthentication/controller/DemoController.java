package com.SpringBoot.MVC.Security.CustomTableAuthentication.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showDashboard() {
        return "DashBoard";
    }
}
