package com.phillip_dev.superstore.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DiscountValidator implements ConstraintValidator<Discount, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // TODO Auto-generated method stub
        return false;
    }
}
