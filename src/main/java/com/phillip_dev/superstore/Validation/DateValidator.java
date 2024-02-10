package com.phillip_dev.superstore.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<Date, Date>{
    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        
        return false;
    }
}
