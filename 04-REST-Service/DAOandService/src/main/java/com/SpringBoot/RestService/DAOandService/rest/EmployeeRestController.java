package com.SpringBoot.RestService.DAOandService.rest;


import com.SpringBoot.RestService.DAOandService.entity.Employee;
import com.SpringBoot.RestService.DAOandService.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private List<Employee> theEmployees;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployee() {
        theEmployees = employeeService.findAll();
        return theEmployees;
    }


    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        // check the employee id
        if (theEmployee == null) {
            throw new EmployeeNotFoundException("Employee not found - "+employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/addEmployee")
    public Employee addNewEmployee(@RequestBody Employee theEmployee) {
        Employee newEmployee = employeeService.save(theEmployee);
        return newEmployee;
    }

    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        Employee updateEmployee = employeeService.save(theEmployee);
        return updateEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeeId(@PathVariable int employeeId) {
        Employee deleteEmployee = employeeService.deleteById(employeeId);
        return "Employee Id deleted Successfull. ID - "+ employeeId;
    }

}
