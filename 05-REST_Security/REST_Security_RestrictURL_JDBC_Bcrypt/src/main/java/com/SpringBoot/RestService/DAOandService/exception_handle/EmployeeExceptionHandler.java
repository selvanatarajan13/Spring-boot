package com.SpringBoot.RestService.DAOandService.exception_handle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    // catch 404 error exception
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exception) {
        EmployeeErrorResponse error = new EmployeeErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return the response entity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeAlreadyExists exception) {
        EmployeeErrorResponse error = new EmployeeErrorResponse();

        error.setStatus(HttpStatus.CONFLICT.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

}
