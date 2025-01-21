package com.SpringBoot.MVC.CRUDBootStrap.controller;

import com.SpringBoot.MVC.CRUDBootStrap.model.Students;
import com.SpringBoot.MVC.CRUDBootStrap.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    public StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String getStudents(Model model) {

        List<Students> theStudents = studentService.findAll();

        model.addAttribute("students",  theStudents);
        return "student-list";
    }

    @GetMapping("/add-new")
    public String addNewStudent(Model model) {

        model.addAttribute("students", new Students());

        return "Add-Student";
    }
    
}
