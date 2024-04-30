package com.test.signin.demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ConfirmPassConstraintValidator.class)
@Target({ElementType.TYPE}) // TYPE is to be used in the whole class
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfirmPass {

    public String message() default "Passwords do not match";

    public Class<?> [] groups () default {};

    public Class<? extends Payload>[] payload() default {};

}
