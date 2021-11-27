import {Observable} from 'rxjs';
import {Breed} from './../models/breed.model';
import {Filter} from '../interfaces/filter.interface';
import {ApiService} from './api.service';
import {StoreService} from './store.service';
import {Injectable} from '@angular/core';

@Injectable({
    providedIn: 'root',
})
export class BreedsService {
    constructor(private readonly store: StoreService, private readonly api: ApiService) {}

    getAll() {
        this.api.getBreeds().subscribe(breeds => {
            this.store.dispatchBreeds(breeds);
        });
    }

    find(params: Filter) {
        this.api.getBreeds(params).subscribe(breeds => {
            this.store.dispatchSearchResult(breeds);
        });
    }

    add(breed: Breed): Observable<unknown> {
        return this.api.setBreed(breed);
    }
}
