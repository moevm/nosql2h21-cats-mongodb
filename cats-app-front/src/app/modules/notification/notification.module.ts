import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {NotificationComponent} from './notification.component';

@NgModule({
    imports: [CommonModule],
    exports: [NotificationComponent],
    declarations: [NotificationComponent],
})
export class NotificationModule {}
