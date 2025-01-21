package com.SpringBoot.REST_Service.PojoAPI.rest;


import com.SpringBoot.REST_Service.PojoAPI.entity.Students;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    // initialize the fields
    private List<Students> theStudents,getStudents;

    // load that students using @PostConstruct . This annotation called only once when it's given bean constucted
    // define @PostConstruct
    @PostConstruct
    public List<Students> loadData() {
        // here, I'm writing hardcoding to insert the students object into the array

        theStudents = new ArrayList<>();
        theStudents.add(new Students("Selvanatarajan","Mahendran"));
        theStudents.add(new Students("Muthu","Manikandan"));
        theStudents.add(new Students("Karthikka","Devi"));

        return theStudents;
    }

    // create a endpoint to get the students objects
    @GetMapping("/students")
    public List<Students> getStudents() {

        return theStudents;
    }

    public void handleException(int studentIndex) {
        if ((studentIndex >= theStudents.size()) || (studentIndex < 0)) {
            throw new StudentNotFoundException("Student ID not Found - "+ studentIndex );
        }
    }

    // retrieve the single data based on the index value
    // define path variable
    @GetMapping("/students/{studentIndex}")
    public Students getStudentById(@PathVariable int studentIndex) {
        // just index into the list
        getStudents = loadData();

        // chect the student if the student is exit or not
        handleException(studentIndex);

        return theStudents.get(studentIndex);
    }

//    // catch 404 error exception
//
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
//
//        // Create a student error response
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(exception.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        // return ResponseEntity
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }
//
//    // catch all exception
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(exception.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        // return ResponseEntity
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }
}
