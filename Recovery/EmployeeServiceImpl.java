package com.Mahend.SpringBoot.SpringBoot.DemoCrud.service;

import com.Mahend.SpringBoot.SpringBoot.DemoCrud.dao.EmployeeDAO;
import com.Mahend.SpringBoot.SpringBoot.DemoCrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {

        Employee employee = employeeDAO.save(theEmployee);
        return employee;
    }

    @Override
    @Transactional
    public String deleteById(int id) {
        String theEmployee = employeeDAO.deleteById(id);
        return theEmployee;
    }
}
