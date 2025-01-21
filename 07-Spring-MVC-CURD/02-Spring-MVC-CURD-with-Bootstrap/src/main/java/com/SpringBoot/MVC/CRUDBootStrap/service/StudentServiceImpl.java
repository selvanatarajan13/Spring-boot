package com.SpringBoot.MVC.CRUDBootStrap.service;

import com.SpringBoot.MVC.CRUDBootStrap.dao.StudentRepository;
import com.SpringBoot.MVC.CRUDBootStrap.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private List<Students> theStudents;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Students> findAll() {

        theStudents = studentRepository.findAll();
        return theStudents;
    }
}
