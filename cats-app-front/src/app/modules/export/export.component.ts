import {BreedsService} from './../../services/breeds.service';
import {FormControl, Validators} from '@angular/forms';
import {NotificationService} from './../../services/notification.service';
import {Component} from '@angular/core';
import {jsonValidator} from 'src/app/consts/validators.const';

@Component({
    selector: 'app-export',
    templateUrl: './export.component.html',
    styleUrls: ['./export.component.less'],
})
export class ExportComponent {
    readonly input = new FormControl(null, [Validators.required, jsonValidator]);

    constructor(
        private readonly notificationService: NotificationService,
        private readonly breedsService: BreedsService,
    ) {}

    export() {
        this.breedsService.addAll(JSON.parse(this.input.value)).subscribe(
            () => {
                this.notificationService.showSuccess('Breeds exported!');
            },
            (e: Error) => {
                this.notificationService.showError(`${e.message}\nPlease, try again`);
            },
        );
    }
}
