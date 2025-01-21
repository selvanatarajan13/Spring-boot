package com.SpringBoot.spring.MVCDemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/hello")
    public String hello(Model model) {
        Model dateandTime = model.addAttribute("DateandTime", LocalDateTime.now());
        return "Helloworld";
    }

    // need to create a controller to show the form..
    @RequestMapping("/showform")
    public String showForm() {
        return "Form.html";
    }

    /* need a controller to process the form data that is to convert uppercase the username
    and show the greeting message with name. */

    /* Here, I'm using special annotation to receive the incoming data instead of using HttpServletRequest */

    /*
    @RequestMapping("/processFrom")
    public String processForm(HttpServletRequest request, Model model) {
        String theName = request.getParameter("UserName");
        theName = theName.toUpperCase();
        model.addAttribute("userName",theName);
        return "greeting";
    }
    */

    @PostMapping("/processFrom")
    public String processForm(@RequestParam("UserName") String theName, Model model) {
//        String theName = request.getParameter("UserName");
        theName = theName.toUpperCase();
        model.addAttribute("userName",theName);
        return "greeting";
    }

}
