import {PipesModule} from './../../pipes/pipes.module';
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BreedsTableComponent} from './breeds-table.component';

@NgModule({
    imports: [CommonModule, PipesModule],
    exports: [BreedsTableComponent],
    declarations: [BreedsTableComponent],
})
export class BreedsTableModule {}
