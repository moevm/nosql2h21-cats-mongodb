import {ReactiveFormsModule} from '@angular/forms';
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AddBreedComponent} from './add-breed.component';

@NgModule({
    imports: [CommonModule, ReactiveFormsModule],
    exports: [AddBreedComponent],
    declarations: [AddBreedComponent],
})
export class AddBreedModule {}
