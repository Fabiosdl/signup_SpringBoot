package com.test.signin.demo.validation;

import com.test.signin.demo.module.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ConfirmPassConstraintValidator implements ConstraintValidator<ConfirmPass,Object> {


    @Override
    public void initialize(ConfirmPass constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {

        boolean result;
        if (object instanceof User){
            User user = (User) object;
            System.out.println("user pass: " + user.getPassword() +
                    "\nuser confirm pass: " + user.getConfirmPassword());
            result = user.getPassword().equals(user.getConfirmPassword());
        }else result = false;
        return result;
    }
}
