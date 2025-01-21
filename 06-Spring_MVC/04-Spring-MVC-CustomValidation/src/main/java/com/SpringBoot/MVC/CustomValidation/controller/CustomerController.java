package com.SpringBoot.MVC.CustomValidation.controller;


import com.SpringBoot.MVC.CustomValidation.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {


    @GetMapping("/customer-form")
    public String showStudentForm(Model theModel) {

        theModel.addAttribute("customer", new Customer());

        return "Customer-Form";
    }

    @PostMapping("/process-form")
    public String confirmForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindResult) {

        if (theBindResult.hasErrors()) {
            return "Customer-Form";
        } else {

            return "Confirm-Form";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder theWebDataBinder) {
        StringTrimmerEditor theStringTrimmerEditior = new StringTrimmerEditor(true);
        theWebDataBinder.registerCustomEditor(String.class,theStringTrimmerEditior);
    }
}
