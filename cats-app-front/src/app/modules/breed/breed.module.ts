import {PipesModule} from './../../pipes/pipes.module';
import {ImageViewerModule} from './../image-viewer/image-viewer.module';
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BreedComponent} from './breed.component';

@NgModule({
    imports: [CommonModule, ImageViewerModule, PipesModule],
    declarations: [BreedComponent],
    exports: [BreedComponent],
})
export class BreedModule {}
