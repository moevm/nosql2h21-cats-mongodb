import {HOST} from './../consts/host.const';
import {BreedsArray} from './../types/breeds-array.type';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';

@Injectable({
    providedIn: 'root',
})
export class ApiService {
    constructor(private readonly http: HttpClient) {}

    getBreeds(parameters: any): Observable<unknown> {
        return this.http.get(`${HOST}/api/v1/breed`, {
            params: parameters,
        });
    }

    loadBreeds(breeds: BreedsArray): Observable<unknown> {
        return this.http.post(`${HOST}/api/v1/breeds`, breeds);
    }
}
