package com.example.spring.mysql.MySQLSpring.service;

import com.example.spring.mysql.MySQLSpring.modal.CategoryEntity;
import com.example.spring.mysql.MySQLSpring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> getAllCategory() {

        List<CategoryEntity> categories = (List<CategoryEntity>) categoryRepository.findAll();
        return categories;
    }
}
