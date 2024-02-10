package com.phillip_dev.superstore.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PriceValidator implements ConstraintValidator<Price, Double>{
    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        
        return false;
    }
}
