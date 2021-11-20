package ru.nosqlproject.catsmongo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;

public class MapIntegerValueValidator implements ConstraintValidator<MapIntegerValueValidate, Map<?, Integer>> {

    int from;
    int to;

    @Override
    public void initialize(MapIntegerValueValidate constraintAnnotation) {
        from = constraintAnnotation.from();
        to = constraintAnnotation.to();
    }

    @Override
    public boolean isValid(Map<?, Integer> map, ConstraintValidatorContext constraintValidatorContext) {
        if (map == null) {
            return true;
        }

        return map.values().stream().allMatch((val) -> val >= from && val <= to);
    }
}
