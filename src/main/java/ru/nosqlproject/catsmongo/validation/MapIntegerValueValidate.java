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
@Constraint(validatedBy = { MapIntegerValueValidator.class })
public @interface MapIntegerValueValidate {
    String message() default "Weight is not valid";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    int from() default 0;
    int to() default 10;
}