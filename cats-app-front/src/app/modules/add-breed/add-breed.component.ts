import {NotificationService} from './../../services/notification.service';
import {filter, map, switchMap} from 'rxjs/operators';
import {Breed} from './../../models/breed.model';
import {BreedsService} from './../../services/breeds.service';
import {intervalValifator} from './../../consts/validators.const';
import {Component} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {characteristicValidators} from 'src/app/consts/validators.const';
import {of} from 'rxjs';

@Component({
    selector: 'app-add-breed',
    templateUrl: './add-breed.component.html',
    styleUrls: ['./add-breed.component.less'],
})
export class AddBreedComponent {
    readonly breedForm = new FormGroup({
        name: new FormControl(null, [
            Validators.required,
            Validators.minLength(3),
            Validators.maxLength(100),
        ]),
        origin: new FormControl(null, [
            Validators.required,
            Validators.minLength(5),
            Validators.maxLength(100),
        ]),
        description: new FormControl(null, [Validators.required]),
        averageLifespan: new FormControl(null, [
            Validators.min(1),
            Validators.max(40),
            Validators.required,
        ]),
        length: new FormControl(null, [intervalValifator, Validators.required]),
        weight: new FormControl(null, [intervalValifator, Validators.required]),
        gentleness: new FormControl(null, [
            ...characteristicValidators,
            Validators.required,
        ]),
        immunity: new FormControl(null, [
            ...characteristicValidators,
            Validators.required,
        ]),
        playfulness: new FormControl(null, [
            ...characteristicValidators,
            Validators.required,
        ]),
        molt: new FormControl(null, [...characteristicValidators, Validators.required]),
        care: new FormControl(null, [...characteristicValidators, Validators.required]),
        intelligence: new FormControl(null, [
            ...characteristicValidators,
            Validators.required,
        ]),
        childFriendliness: new FormControl(null, [
            ...characteristicValidators,
            Validators.required,
        ]),
        petFriendliness: new FormControl(null, [
            ...characteristicValidators,
            Validators.required,
        ]),
        images: new FormControl(null, [Validators.required]),
    });

    constructor(
        private readonly breedsService: BreedsService,
        private readonly notificationService: NotificationService,
    ) {}

    addBreed() {
        of(this.breedForm.valid)
            .pipe(
                filter(vaild => vaild),
                map(() => this.mapToBreed()),
                switchMap(breed => this.breedsService.add(breed)),
            )
            .subscribe(
                () => {
                    this.breedForm.reset();
                    this.notificationService.showSuccess('Breed added!');
                },
                () => {
                    this.notificationService.showError('Try again later');
                },
            );
    }

    private mapToBreed(): Breed {
        const length = (this.breedForm.value.length as string).split('-');
        const weight = (this.breedForm.value.weight as string).split('-');
        const images = (this.breedForm.value.images as string).split(/\s/g);

        return {
            name: this.breedForm.value.name,
            origin: this.breedForm.value.origin,
            averageLifespan: this.breedForm.value.averageLifespan,
            length: {
                from: Number.parseInt(length[0]),
                to: Number.parseInt(length[1]),
            },
            weight: {
                from: Number.parseInt(weight[0]),
                to: Number.parseInt(weight[1]),
            },
            characteristics: {
                gentleness: this.breedForm.value.gentleness,
                immunity: this.breedForm.value.immunity,
                playfulness: this.breedForm.value.playfulness,
                molt: this.breedForm.value.molt,
                care: this.breedForm.value.care,
                intelligence: this.breedForm.value.intelligence,
                childFriendliness: this.breedForm.value.childFriendliness,
                petFriendliness: this.breedForm.value.petFriendliness,
            },
            description: this.breedForm.value.description,
            images: images,
        };
    }
}
