package com.SpringBoot.MVC.Validation.controller;

import com.SpringBoot.MVC.Validation.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {


    @GetMapping("/customer-form")
    public String showCustomerForm(Model theModel) {

        theModel.addAttribute("customer", new Customer());

        return "Customer-Form";
    }

    @PostMapping("/process-customer-form")
    public String processCutomerForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {

        // @Valid annotation tells it to perform validation

        if (theBindingResult.hasErrors()) {
            return showForm();
        } else {
            return "Confirm-Form";
        }
    }

    public String showForm() {
        return "Customer-Form";
    }


    // remove whitespace from the incoming data
    // And solving the white space validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

}
