import {StringIntervalPipe} from './string-interval.pipe';
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

@NgModule({
    imports: [CommonModule],
    exports: [StringIntervalPipe],
    declarations: [StringIntervalPipe],
})
export class PipesModule {}
