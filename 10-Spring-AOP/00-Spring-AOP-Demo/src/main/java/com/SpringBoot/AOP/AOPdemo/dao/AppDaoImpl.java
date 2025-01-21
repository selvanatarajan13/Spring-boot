package com.SpringBoot.AOP.AOPdemo.dao;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class AppDaoImpl implements AppDao {
    @Override
    public void addAccount() {
        System.out.println("Doing DB work : Add an account to db");
    }

    @Override
    public void addBook() {
        System.out.println("Doing DB work : Add an book to db");
    }
}