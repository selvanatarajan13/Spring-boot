package com.SpringBoot.Advice.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AppDaoImpl implements AppDao {
    @Override
    public void addAccount() {
        System.out.println("Do some work in db: add account in db");
    }
}
