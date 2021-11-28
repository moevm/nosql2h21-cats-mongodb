import {Component, Input} from '@angular/core';

@Component({
    selector: 'app-notification',
    templateUrl: './notification.component.html',
    styleUrls: ['./notification.component.less'],
})
export class NotificationComponent {
    @Input()
    readonly message = '';
}
