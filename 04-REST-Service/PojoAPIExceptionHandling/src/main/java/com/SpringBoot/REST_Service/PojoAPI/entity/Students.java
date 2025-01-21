package com.SpringBoot.REST_Service.PojoAPI.entity;

public class Students {

    // initialize the fields
    private String firstName;
    private String lastName;

    // create constructor

    public Students(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    // create getter and setter method

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    // define toString() method

    @Override
    public String toString() {
        return "Students{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
