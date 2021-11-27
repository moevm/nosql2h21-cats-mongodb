package ru.nosqlproject.catsmongo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;

/**
 * @author Kirill Mololkin 19.11.2021
 */
public class FromToMapValidator implements ConstraintValidator<FromToMapsCustomValidate, Map<String, Integer>> {

    @Override
    public boolean isValid(Map<String, Integer> map, ConstraintValidatorContext constraintValidatorContext) {
        if (map == null) {
            return false;
        }

        if (map.containsKey("from") && map.containsKey("to")) {
            Integer fromVal = map.get("from");
            Integer toVal = map.get("to");

            return fromVal > 0 && toVal > fromVal;
        }

        return false;
    }
}
