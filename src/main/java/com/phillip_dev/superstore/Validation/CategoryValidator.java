package com.phillip_dev.superstore.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CategoryValidator implements ConstraintValidator<Category, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
       if(value.equals("Choose Category")) return true;
        return false;
    }
}
