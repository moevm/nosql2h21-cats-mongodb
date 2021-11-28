import {Validators} from '@angular/forms';

const intervalPattern = /^(\d)+-(\d)+$/;

export const characteristicValidators = [Validators.min(1), Validators.max(10)];
export const intervalValifator = Validators.pattern(intervalPattern);
