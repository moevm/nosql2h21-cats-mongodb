import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
    selector: 'app-search',
    templateUrl: './search.component.html',
    styleUrls: ['./search.component.less'],
})
export class SearchComponent implements OnInit {
    readonly filterForm = new FormGroup({
        name: new FormControl(null, []),
        origin: new FormControl(null, []),
        averageLifespanFrom: new FormControl(null, []),
        averageLifespanTo: new FormControl(null, []),
        lengthFrom: new FormControl(null, []),
        lengthTo: new FormControl(null, []),
        weightFrom: new FormControl(null, []),
        weightTo: new FormControl(null, []),
    });

    ngOnInit() {
        this.filterForm.valueChanges.subscribe(v => console.log(v));
        this.filterForm.statusChanges.subscribe(v => console.log(v));
    }
}
