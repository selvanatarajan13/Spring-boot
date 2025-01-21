package com.SpringBoot.MVC.CRUDBootStrap.dao;

import com.SpringBoot.MVC.CRUDBootStrap.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Students, Integer> {

}
