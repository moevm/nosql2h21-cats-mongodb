import {BreedsArray} from './../types/breeds-array.type';
import {Observable} from 'rxjs';
import {Breed} from './../models/breed.model';
import {Filter} from '../interfaces/filter.interface';
import {ApiService} from './api.service';
import {StoreService} from './store.service';
import {Injectable} from '@angular/core';
import {map, tap} from 'rxjs/operators';

@Injectable({
    providedIn: 'root',
})
export class BreedsService {
    constructor(private readonly store: StoreService, private readonly api: ApiService) {}

    getAll(): Observable<BreedsArray> {
        return this.api.getBreeds().pipe(
            tap(breeds => {
                this.store.dispatchBreeds(breeds);
            }),
        );
    }

    get(name: string): Observable<Breed | null> {
        return this.api
            .getBreeds({name})
            .pipe(map(breeds => (breeds.length ? breeds[0] : null)));
    }

    find(params: Filter): Observable<BreedsArray> {
        return this.api.getBreeds(params).pipe(
            tap(breeds => {
                this.store.dispatchSearchResult(breeds);
            }),
        );
    }

    add(breed: Breed): Observable<unknown> {
        return this.api.setBreed(breed);
    }

    addAll(breeds: BreedsArray): Observable<unknown> {
        return this.api.setBreeds(breeds);
    }
}
