package com.SpringBoot.MVC.CustomValidation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword,String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {

        boolean container = false;
        char[] array = password.toCharArray();
        if (password != null && password.length() >= 8) {
            for (char ch : array) {
                if (Character.isUpperCase(ch)) {
                    container = true;
                    break;
                }
            }
        }


        return container;
    }
}
