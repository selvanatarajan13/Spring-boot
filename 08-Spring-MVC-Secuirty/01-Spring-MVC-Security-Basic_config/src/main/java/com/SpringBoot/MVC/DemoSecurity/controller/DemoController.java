package com.SpringBoot.MVC.DemoSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {


    @GetMapping("/students")
    public String home(Model theModel) {
        return "welcome-page";
    }



}
