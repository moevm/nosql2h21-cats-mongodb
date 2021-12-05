import {map, filter, switchMap} from 'rxjs/operators';
import {BreedsService} from './../../services/breeds.service';
import {ClipboardService} from './../../services/clipboard.service';
import {NotificationService} from './../../services/notification.service';
import {Component} from '@angular/core';
import {BehaviorSubject} from 'rxjs';

@Component({
    selector: 'app-import',
    templateUrl: './import.component.html',
    styleUrls: ['./import.component.less'],
})
export class ImportComponent {
    readonly imported$ = new BehaviorSubject(false);
    readonly data$ = new BehaviorSubject('');

    constructor(
        private readonly notificationService: NotificationService,
        private readonly clipboardService: ClipboardService,
        private readonly breedsService: BreedsService,
    ) {}

    import() {
        this.breedsService
            .getAll()
            .pipe(map(breeds => JSON.stringify(breeds)))
            .subscribe(
                breeds => {
                    this.imported$.next(true);
                    this.data$.next(breeds);
                },
                () => {
                    this.notificationService.showError('Import failed');
                },
            );
    }

    copy() {
        this.data$
            .pipe(
                filter(() => this.imported$.value),
                switchMap(text => this.clipboardService.copy(text)),
            )
            .subscribe(
                () => {
                    this.notificationService.showSuccess('Copied to clipboard!');
                },
                () => {
                    this.notificationService.showError(
                        'Copied with an error. Please, try again',
                    );
                },
            );
    }
}
