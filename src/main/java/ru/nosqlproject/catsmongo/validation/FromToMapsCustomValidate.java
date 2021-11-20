package ru.nosqlproject.catsmongo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { FromToMapValidator.class })
public @interface FromToMapsCustomValidate {
    String message() default "Not valid";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
