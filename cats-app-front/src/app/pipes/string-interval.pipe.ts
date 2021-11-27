import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
    name: 'toStringInterval',
})
export class StringIntervalPipe implements PipeTransform {
    transform(value: {from: number; to: number}): string {
        return `${value.from}-${value.to}`;
    }
}
