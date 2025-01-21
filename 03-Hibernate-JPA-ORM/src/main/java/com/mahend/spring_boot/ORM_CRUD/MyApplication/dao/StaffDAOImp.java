package com.mahend.spring_boot.ORM_CRUD.MyApplication.dao;

import com.mahend.spring_boot.ORM_CRUD.MyApplication.entity.Staff;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StaffDAOImp implements StaffDAO{

    private EntityManager entityManager;

    // create constructor
    public void DemoName(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Staff theStaff) {
        Staff value = new Staff();
        value.toString();
//        entityManager.persist(theStaff);
    }
}
