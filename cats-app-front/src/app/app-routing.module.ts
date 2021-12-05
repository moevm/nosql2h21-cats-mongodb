import {BreedResolver} from './resolvers/breed.resolver';
import {BreedComponent} from './modules/breed/breed.component';
import {AddBreedComponent} from './modules/add-breed/add-breed.component';
import {LandingComponent} from './modules/landing/landing.component';
import {ExportComponent} from './modules/export/export.component';
import {ImportComponent} from './modules/import/import.component';
import {SearchComponent} from './modules/search/search.component';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

const routes: Routes = [
    {
        path: 'breed/:name',
        component: BreedComponent,
        resolve: {
            breed: BreedResolver,
        },
    },
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
        path: 'add',
        component: AddBreedComponent,
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
