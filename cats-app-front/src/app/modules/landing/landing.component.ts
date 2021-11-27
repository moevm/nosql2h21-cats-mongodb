import {StoreService} from './../../services/store.service';
import {Component} from '@angular/core';
import {startWith} from 'rxjs/operators';

@Component({
    selector: 'app-landing',
    templateUrl: './landing.component.html',
    styleUrls: ['./landing.component.less'],
})
export class LandingComponent {
    readonly breedsCount$ = this.store.breedsCount$.pipe(startWith(0));

    constructor(private readonly store: StoreService) {}
}
