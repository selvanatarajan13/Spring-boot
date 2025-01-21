package com.SpringBoot.MVC.Validation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidated implements ConstraintValidator<ValidPassword, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {

        boolean containerContainUppercase = false;

        char[] array = password.toCharArray();
        if (password != null && password.length() >= 8) {
            for (char ch : array) {
                if (Character.isUpperCase(ch)) {
                    containerContainUppercase = true;
                    break;
                }
            }
        }
        return containerContainUppercase;
    }


}
