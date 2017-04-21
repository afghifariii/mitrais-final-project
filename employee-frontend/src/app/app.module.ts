import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { MdToolbarModule, MdGridListModule, MdButtonModule, MdIconModule, MdCardModule } from "@angular/material";
import { FlexLayoutModule } from '@angular/flex-layout';

import { EmployeeListComponent } from "./employee/employee-list/employee-list.component";
import { EmployeeDetailComponent } from './employee/employee-detail/employee-detail.component';
import { AppComponent } from './app.component';

import { EmployeeService } from "./employee/employee.service";
import { LocationService } from "./location/location.service";


@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    EmployeeDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    MdToolbarModule, 
    MdGridListModule, 
    MdButtonModule, 
    MdIconModule, 
    MdCardModule,
    FlexLayoutModule,
    BrowserAnimationsModule
  ],
  providers: [EmployeeService, LocationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
