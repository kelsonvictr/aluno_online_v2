package com.alunoonline.api.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class NomeValidator implements
        ConstraintValidator<NomeValidation, String> {


    private String message;

    @Override
    public void initialize(NomeValidation constraintAnnotation) {
        message = constraintAnnotation.message();
    }


    @Override
    public boolean isValid(String nome, ConstraintValidatorContext constraintValidatorContext) {
        if(nome.contains("Fujioka")){
            return true;
        }
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(message + nome)//
                .addConstraintViolation();
        return false;
    }
}
