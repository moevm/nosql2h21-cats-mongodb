import {LandingComponent} from './modules/landing/landing.component';
import {ExportComponent} from './modules/export/export.component';
import {ImportComponent} from './modules/import/import.component';
import {SearchComponent} from './modules/search/search.component';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

const routes: Routes = [
    {
        path: 'search',
        component: SearchComponent,
    },
    {
        path: 'import',
        component: ImportComponent,
    },
    {
        path: 'export',
        component: ExportComponent,
    },
    {
        path: '',
        component: LandingComponent,
    },
    {
        path: '**',
        redirectTo: '',
    },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule {}
