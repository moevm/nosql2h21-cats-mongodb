import {BreedsArray} from './../types/breeds-array.type';
import {Injectable} from '@angular/core';
import {Observable, ReplaySubject} from 'rxjs';
import {map} from 'rxjs/operators';

@Injectable({
    providedIn: 'root',
})
export class StoreService {
    private readonly _breeds$ = new ReplaySubject<BreedsArray>(1);
    private readonly _searchResult$ = new ReplaySubject<BreedsArray>(1);

    get breeds$(): Observable<BreedsArray> {
        return this._breeds$.asObservable();
    }

    get breedsCount$(): Observable<number> {
        return this._breeds$.pipe(map(breeds => breeds.length));
    }

    get searchResult$(): Observable<BreedsArray> {
        return this._searchResult$.asObservable();
    }

    dispatchBreeds(breeds: BreedsArray) {
        this._breeds$.next(breeds);
    }

    dispatchSearchResult(results: BreedsArray) {
        this._searchResult$.next(results);
    }
}
