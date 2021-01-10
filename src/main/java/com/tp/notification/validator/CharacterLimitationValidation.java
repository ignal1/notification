package com.tp.notification.validator;

import com.tp.notification.annotation.constraints.CharacterLimitation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CharacterLimitationValidation implements ConstraintValidator<CharacterLimitation, String> {
    @Override
    public void initialize(CharacterLimitation constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches("^(([a-z\\d])(?:[a-z\\d]|-(?=[a-z\\d])){0,}){0,}$");
    }
}
