import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { FlexLayoutModule } from '@angular/flex-layout';
import { MdToolbarModule, MdGridListModule, MdButtonModule, MdIconModule, MdCardModule } from '@angular/material';

import { AppComponent } from './app.component';
import { EmployeeComponent } from './employee/employee.component';
import { LocationComponent } from './location/location.component';

import { EmployeeService } from "./employee/employee.service";
import { LocationService } from "./location/location.service";

@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    LocationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    MdToolbarModule,
    MdGridListModule,
    MdButtonModule,
    MdIconModule,
    BrowserAnimationsModule,
    MdCardModule,
    FlexLayoutModule
  ],
  providers: [EmployeeService, LocationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
