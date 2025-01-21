package com.mahend.spring_boot.ORM_CRUD.MyApplication.dao;

import com.mahend.spring_boot.ORM_CRUD.MyApplication.entity.Students;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public abstract class StudentDAOImp implements studentDAO {

    private EntityManager entityManager;
    private Object List;

    @Autowired
    public StudentDAOImp(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    @Transactional
    public void save(Students theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public <Intger> Students findById(Intger id) {
        Students result = entityManager.find(Students.class, id);
        return result;
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
        // retrieve student object
        Students retrieveData = entityManager.find(Students.class, id);

        // delete student object
        entityManager.remove(retrieveData);
    }


    @Override
    public List<Students> findsAll() {
        // create query
        TypedQuery<Students> query = entityManager.createQuery("FROM Students order by firstName", Students.class);

        // return query result
        return query.getResultList();
    }


}
