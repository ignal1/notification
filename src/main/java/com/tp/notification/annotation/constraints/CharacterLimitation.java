package com.tp.notification.annotation.constraints;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.tp.notification.validator.CharacterLimitationValidation;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CharacterLimitationValidation.class)
public @interface CharacterLimitation {
    String message() default "����� ����� �������� �������� ����� ���������� ��������, ����� � ��������� ������, �� ����� ���������� ��� ������������� �������";
    Class<?>[] groups() default {};
    public abstract Class<? extends Payload>[] payload() default {};
}
