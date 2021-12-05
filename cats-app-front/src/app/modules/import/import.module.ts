import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ImportComponent} from './import.component';

@NgModule({
    imports: [CommonModule],
    declarations: [ImportComponent],
    exports: [ImportComponent],
})
export class ImportModule {}
