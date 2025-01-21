package com.SpringBoot.RestService.DAOandService.service;

import com.SpringBoot.RestService.DAOandService.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee theEmployee);

    Employee deleteById(int id);
}
