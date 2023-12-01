package com.example.demo.validators;


import com.example.demo.domain.Part;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsInvValid implements ConstraintValidator<InvRange, Part>{


    @Override
    public void initialize(InvRange constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if(part.getMaxInventory()>=part.getInv()&& part.getMinInventory()<=part.getInv()){
            return true;
        }
        return false;
    }
}

