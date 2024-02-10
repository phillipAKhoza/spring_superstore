package com.phillip_dev.superstore.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NegativeNumberValidator implements ConstraintValidator<NegativeNumber, Double> {
    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        if (value >=-1) return true;
        return false;
    }
}
