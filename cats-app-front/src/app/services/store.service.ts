import {Breed} from './../models/breed.model';
import {Injectable} from '@angular/core';
import {Observable, ReplaySubject} from 'rxjs';
import {map} from 'rxjs/operators';

@Injectable({
    providedIn: 'root',
})
export class StoreService {
    private readonly breeds$ = new ReplaySubject<ReadonlyArray<Breed>>(1);

    get breedsCount$(): Observable<number> {
        return this.breeds$.pipe(map(breeds => breeds.length));
    }
}
