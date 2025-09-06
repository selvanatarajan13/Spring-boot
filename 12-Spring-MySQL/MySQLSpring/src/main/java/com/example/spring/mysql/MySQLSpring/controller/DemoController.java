package com.example.spring.mysql.MySQLSpring.controller;

import com.example.spring.mysql.MySQLSpring.modal.CategoryEntity;
import com.example.spring.mysql.MySQLSpring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("get-employees")
public class DemoController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("data")
    public ResponseEntity<List<CategoryEntity>> getCategories() {
        List<CategoryEntity> categories = categoryService.getAllCategory();
        return ResponseEntity.ok(categories);
    }
}
