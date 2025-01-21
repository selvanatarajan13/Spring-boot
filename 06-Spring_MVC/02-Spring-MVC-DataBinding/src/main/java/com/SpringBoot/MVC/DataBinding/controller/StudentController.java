package com.SpringBoot.MVC.DataBinding.controller;

import com.SpringBoot.MVC.DataBinding.model.Students;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/form")
public class StudentController {

    @Value("${countries}")
    private List<String> theCountries;

    @Value("${languages}")
    private List<String> theLanguages;

    @GetMapping("/show-student-form")
    public String showStudentForm(Model theModel) {
        Students theStudents = new Students();
        theModel.addAttribute("students", theStudents);
        theModel.addAttribute("countries", theCountries);
        theModel.addAttribute("languages", theLanguages);
        return "Student-Form";
    }

    @PostMapping("/confirm-student")
    public String confirmStudentForm(@ModelAttribute("students") Students theStudents) {
        return "Confirm-Form";
    }
}
