package com.phillip_dev.superstore.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<Name, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        System.err.println(value.contains("$%#@^*"));
        System.err.println(value.contains("$%#@^*"));
        if(value.contains("$%#@^*")) return true;

        return false;
    }
}
