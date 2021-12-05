import {filter, map} from 'rxjs/operators';
import {Breed} from './../../models/breed.model';
import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {ReplaySubject} from 'rxjs';

@Component({
    selector: 'app-breed',
    templateUrl: './breed.component.html',
    styleUrls: ['./breed.component.less'],
})
export class BreedComponent implements OnInit {
    readonly breed$ = new ReplaySubject<Breed>(1);

    constructor(private readonly route: ActivatedRoute) {}

    ngOnInit() {
        this.route.data
            .pipe(
                filter(data => data.breed),
                map(data => data.breed as Breed),
            )
            .subscribe(this.breed$);
    }
}
