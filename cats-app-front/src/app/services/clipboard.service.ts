import {Injectable} from '@angular/core';

@Injectable({
    providedIn: 'root',
})
export class ClipboardService {
    copy(text: string): Promise<void> {
        return window.navigator.clipboard.writeText(text);
    }
}
