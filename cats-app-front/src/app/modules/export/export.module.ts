import {ReactiveFormsModule} from '@angular/forms';
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ExportComponent} from './export.component';

@NgModule({
    imports: [CommonModule, ReactiveFormsModule],
    declarations: [ExportComponent],
    exports: [ExportComponent],
})
export class ExportModule {}
