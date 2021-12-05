import {BehaviorSubject} from 'rxjs';
import {Component, Input} from '@angular/core';

@Component({
    selector: 'app-image-viewer',
    templateUrl: './image-viewer.component.html',
    styleUrls: ['./image-viewer.component.less'],
})
export class ImageViewerComponent {
    @Input()
    images!: ReadonlyArray<string>;

    readonly position$ = new BehaviorSubject<number>(0);

    get position(): number {
        return this.position$.value;
    }

    left() {
        if (this.position$.value > 0) {
            this.position$.next(this.position$.value - 1);
        }
    }

    right() {
        if (this.position$.value < this.images.length - 1) {
            this.position$.next(this.position$.value + 1);
        }
    }
}
