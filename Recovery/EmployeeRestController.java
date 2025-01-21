package com.Mahend.SpringBoot.SpringBoot.DemoCrud.rest;

import com.Mahend.SpringBoot.SpringBoot.DemoCrud.entity.Employee;
import com.Mahend.SpringBoot.SpringBoot.DemoCrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    /*
    *  When sending JSON data to spring REST Controller
    *  For controller to process JSON data, need to set a HTTP request header
    * */

    private EmployeeService employeeService;

    // inject EmployeeDAO to use DB
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // expose "/employee" and return a list of employee's
    // This is GET request
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }


    // HTTP Request - GET request
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - "+theEmployee);
        }

        return theEmployee;
    }

    // add mapping for POST request to add new employee
    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee theEmployee) {
        // in this case they pass an id in JSON. set id to 0
        // this is force a save of new item
        /*
            here, the employee data come in the request body as JSON.
            so need to make use of @RequestBody annotation                                                                                                                                      @Req
         */

        theEmployee.setId(0);
        Employee result = employeeService.save(theEmployee);

        return result;
    }


    // add mapping for Update employee using @PutMapping
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        // This update fn work as same as the save method
        // here simply call the save method

        Employee updateEmployee = employeeService.save(theEmployee);

        return updateEmployee;
    }


    // add mapping for Delete employee
    @DeleteMapping("/employees/{employeeId}")
    public Employee deleteEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - "+theEmployee+". Cannot perform delete operation");
        }
        else {
            String s = employeeService.deleteById(employeeId);
        }
        return theEmployee;
    }
}
