package com.SpringBoot.RestService.DAOandService.dao;

import com.SpringBoot.RestService.DAOandService.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);


    Employee save(Employee theEmployee);

    void deleteById(int id);
}
