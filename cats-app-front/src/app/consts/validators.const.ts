import {AbstractControl, ValidationErrors, ValidatorFn, Validators} from '@angular/forms';

const intervalPattern = /^(\d)+-(\d)+$/;

export const characteristicValidators = [Validators.min(1), Validators.max(10)];
export const intervalValifator = Validators.pattern(intervalPattern);
export const jsonValidator: ValidatorFn = (
    control: AbstractControl,
): ValidationErrors | null => {
    try {
        const json = JSON.parse(control.value);
    } catch {
        return {jsonValid: false};
    }

    return null;
};
