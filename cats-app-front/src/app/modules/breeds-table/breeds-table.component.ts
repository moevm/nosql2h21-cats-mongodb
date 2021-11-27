import {BreedsArray} from './../../types/breeds-array.type';
import {Component, Input} from '@angular/core';

@Component({
    selector: 'app-breeds-table',
    templateUrl: './breeds-table.component.html',
    styleUrls: ['./breeds-table.component.less'],
})
export class BreedsTableComponent {
    @Input()
    breeds: BreedsArray = [];
}
