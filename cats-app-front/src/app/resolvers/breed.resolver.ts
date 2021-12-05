import {BreedsService} from './../services/breeds.service';
import {Breed} from './../models/breed.model';
import {Injectable} from '@angular/core';
import {Resolve, RouterStateSnapshot, ActivatedRouteSnapshot} from '@angular/router';
import {Observable, of} from 'rxjs';

@Injectable({
    providedIn: 'root',
})
export class BreedResolver implements Resolve<Breed | null> {
    resolve(
        route: ActivatedRouteSnapshot,
        state: RouterStateSnapshot,
    ): Observable<Breed | null> {
        const name = route.paramMap.get('name');

        return name ? this.breedsService.get(name) : of(null);
    }

    constructor(private readonly breedsService: BreedsService) {}
}
