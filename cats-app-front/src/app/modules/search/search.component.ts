import {Filter} from './../../interfaces/filter.interface';
import {BreedsService} from './../../services/breeds.service';
import {debounceTime, filter, take, map} from 'rxjs/operators';
import {StoreService} from './../../services/store.service';
import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {concat} from 'rxjs';
import {removeNullKeys} from 'src/app/utils/remove-null-keys.util';
import {generateMocks} from 'src/app/mocks/breeds.mock';

const characteristicValidators = [Validators.min(1), Validators.max(10)];

@Component({
    selector: 'app-search',
    templateUrl: './search.component.html',
    styleUrls: ['./search.component.less'],
})
export class SearchComponent implements OnInit {
    readonly filterForm = new FormGroup({
        name: new FormControl(null, []),
        origin: new FormControl(null, []),
        description: new FormControl(null, []),
        averageLifespanFrom: new FormControl(null, [Validators.min(1)]),
        averageLifespanTo: new FormControl(null, [Validators.min(1)]),
        lengthFrom: new FormControl(null, [Validators.min(1)]),
        lengthTo: new FormControl(null, [Validators.min(1)]),
        weightFrom: new FormControl(null, [Validators.min(1)]),
        weightTo: new FormControl(null, [Validators.min(1)]),
        gentlenessFrom: new FormControl(null, characteristicValidators),
        gentlenessTo: new FormControl(null, characteristicValidators),
        immunityFrom: new FormControl(null, characteristicValidators),
        immunityTo: new FormControl(null, characteristicValidators),
        playfulnessFrom: new FormControl(null, characteristicValidators),
        playfulnessTo: new FormControl(null, characteristicValidators),
        moltFrom: new FormControl(null, characteristicValidators),
        moltTo: new FormControl(null, characteristicValidators),
        careFrom: new FormControl(null, characteristicValidators),
        careTo: new FormControl(null, characteristicValidators),
        intelligenceFrom: new FormControl(null, characteristicValidators),
        intelligenceTo: new FormControl(null, characteristicValidators),
        childFriendlinessFrom: new FormControl(null, characteristicValidators),
        childFriendlinessTo: new FormControl(null, characteristicValidators),
        petFriendlinessFrom: new FormControl(null, characteristicValidators),
        petFriendlinessTo: new FormControl(null, characteristicValidators),
    });

    readonly searchResult$ = concat(
        this.store.breeds$.pipe(take(1)),
        this.store.searchResult$,
    );

    filterShow = false;

    private get valid(): boolean {
        return this.filterForm.valid;
    }

    constructor(
        private readonly store: StoreService,
        private readonly breedsService: BreedsService,
    ) {}

    ngOnInit() {
        // this.store.dispatchBreeds(generateMocks());
        this.filterForm.valueChanges
            .pipe(
                filter<Filter>(() => this.valid),
                debounceTime(600),
                map(filter => removeNullKeys(filter)),
            )
            .subscribe(filter => {
                this.breedsService.search(filter);
            });
    }

    changeFilterVisibilily() {
        this.filterShow = !this.filterShow;
    }
}
