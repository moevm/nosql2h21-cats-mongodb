import { AddBreedModule } from './modules/add-breed/add-breed.module';
import {SearchModule} from './modules/search/search.module';
import {ImportModule} from './modules/import/import.module';
import {ExportModule} from './modules/export/export.module';
import {LandingModule} from './modules/landing/landing.module';
import {HeaderModule} from './modules/header/header.module';
import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
    declarations: [AppComponent],
    imports: [
        BrowserModule,
        HeaderModule,
        LandingModule,
        ExportModule,
        ImportModule,
        SearchModule,
        AddBreedModule,
        AppRoutingModule,
        HttpClientModule,
    ],
    providers: [],
    bootstrap: [AppComponent],
})
export class AppModule {}
