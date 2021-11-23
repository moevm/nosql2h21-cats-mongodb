import {BreedsTableModule} from './../breeds-table/breeds-table.module';
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SearchComponent} from './search.component';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
    imports: [CommonModule, ReactiveFormsModule, BreedsTableModule],
    declarations: [SearchComponent],
})
export class SearchModule {}
