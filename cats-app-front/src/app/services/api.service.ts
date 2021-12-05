import {Breed} from './../models/breed.model';
import {Filter} from './../interfaces/filter.interface';
import {HOST} from './../consts/host.const';
import {BreedsArray} from './../types/breeds-array.type';
import {Observable, of} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError} from 'rxjs/operators';

@Injectable({
    providedIn: 'root',
})
export class ApiService {
    constructor(private readonly http: HttpClient) {}

    getBreeds(parameters?: Filter): Observable<BreedsArray> {
        return this.http
            .get<BreedsArray>(`${HOST}/api/v1/breed`, {
                params: {...parameters},
            })
            .pipe(catchError(e => of([])));
    }

    getBreed(name: string): Observable<Breed | null> {
        return this.http
            .get<Breed>(`${HOST}/breed/${name}`)
            .pipe(catchError(e => of(null)));
    }

    setBreed(breed: Breed): Observable<unknown> {
        return this.http.post(`${HOST}/api/v1/breed`, breed);
    }

    setBreeds(breeds: BreedsArray): Observable<unknown> {
        return this.http.post(`${HOST}/api/v1/breeds`, breeds);
    }
}
