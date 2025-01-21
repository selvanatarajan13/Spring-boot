package com.Mahend.SpringBoot.SpringBoot.DemoCrud.dao;

import com.Mahend.SpringBoot.SpringBoot.DemoCrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImp implements EmployeeDAO{

    // initialize the entity manager
    private EntityManager entityManager;

    // setup the constructor injection

    @Autowired
    public EmployeeDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // write the query for retrieve the objects from db
        TypedQuery<Employee> myQuery = entityManager.createQuery("from Employee",Employee.class);

        // execute the query and get the result
        List<Employee> employees = myQuery.getResultList();

        // return the result
        return employees;
    }

    @Override
    public Employee findById(int id) {
        // Retrieve the employee
        Employee theEmployee = entityManager.find(Employee.class, id);

        // return employee based on theEmployee
        return theEmployee;

    }

    @Override
    public Employee save(Employee theEmployee) {

        Employee myEmployee = entityManager.merge(theEmployee);
        return myEmployee;
    }

    @Override
    public String deleteById(int id) {
        // retrieve the id
        Employee theEmployee = entityManager.find(Employee.class, id);

        // delete id
        entityManager.remove(theEmployee);
        return "ID deleted successfully - "+id;
    }


}
