import {Injectable} from '@angular/core';

@Injectable({
    providedIn: 'root',
})
export class NotificationService {
    showSuccess(message: string) {
        alert(`SUCCESS: ${message}`);
    }

    showError(message: string) {
        alert(`FAIL: ${message}`);
    }
}
