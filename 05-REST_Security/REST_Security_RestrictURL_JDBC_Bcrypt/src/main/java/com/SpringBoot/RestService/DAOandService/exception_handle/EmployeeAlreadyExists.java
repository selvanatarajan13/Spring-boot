package com.SpringBoot.RestService.DAOandService.exception_handle;

public class EmployeeAlreadyExists extends RuntimeException {

    public EmployeeAlreadyExists(String message) {
        super(message);
    }
}
