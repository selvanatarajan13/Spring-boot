package com.SpringBoot.RestService.DAOandService.dao;

import com.SpringBoot.RestService.DAOandService.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImp implements EmployeeDAO {

    private EntityManager entityManager;
    private List<Employee> theEmployees;

    public EmployeeDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a typedQuery

        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);
        theEmployees = theQuery.getResultList();

        return theEmployees;
    }

    @Override
    public Employee findById(int id) {
        Employee theEmployee = entityManager.find(Employee.class, id);

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee saveEmployee = entityManager.merge(theEmployee);

        return saveEmployee;
    }

    @Override
    public void deleteById(int id) {
        // create a query
        Employee myQuery = entityManager.find(Employee.class, id);

        // delete the id
        entityManager.remove(myQuery);
    }
}
