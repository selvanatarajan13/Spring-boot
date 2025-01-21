package com.Mahend.SpringBoot.SpringBoot.DemoCrud.dao;

import com.Mahend.SpringBoot.SpringBoot.DemoCrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee theEmployee);

    String deleteById(int id);
}
