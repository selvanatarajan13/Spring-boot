package com.SpringBoot.MVC.Validation.model;


import com.SpringBoot.MVC.Validation.validation.ValidPassword;
import jakarta.validation.constraints.*;

public class Customer {
    // initialize fields with validation rule

    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @NotNull(message = "is requird")
    @Min(value = 300, message = "must be greater than or equal to 300")
    @Max(value = 600, message = "must be less than or equal to 600")
    private int mark;

    @Email(message = "Not valid")
    private String email;

    @ValidPassword(message = "is not valid")
    private String password;


    // define getter and setter method to retrieve and store data

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public @NotNull(message = "is required") @Size(min = 1, message = "This field contain minimum 1 char") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull(message = "is required") @Size(min = 1, message = "This field contain minimum 1 char") String lastName) {
        this.lastName = lastName;
    }

    @NotNull(message = "is requird")
    @Min(value = 300, message = "must be greater than or equal to 300")
    @Max(value = 600, message = "must be less than or equal to 600")
    public int getMark() {
        return mark;
    }

    public void setMark(@NotNull(message = "is requird") @Min(value = 300, message = "must be greater than or equal to 300") @Max(value = 600, message = "must be less than or equal to 600") int mark) {
        this.mark = mark;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
