import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { ReactiveFormsModule } from '@angular/forms';

import { MdButtonModule, MdIconModule, MdInputModule, MdChipsModule, MdTabsModule, MdProgressSpinnerModule, MdSelectModule } from "@angular/material";
import { FlexLayoutModule } from '@angular/flex-layout';

import { EmployeeListComponent } from "./employee/employee-list/employee-list.component";
import { EmployeeDetailComponent } from './employee/employee-detail/employee-detail.component';
import { AppComponent } from './app.component';

import { EmployeeService } from "./employee/employee.service";
import { LocationService } from "./location/location.service";
import { BtnSvgComponent } from './btn-svg/btn-svg.component';
import { EmployeeItemComponent } from './employee/employee-item/employee-item.component';
import { EmployeeFilterComponent } from './employee/employee-filter/employee-filter.component';


@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    EmployeeDetailComponent,
    BtnSvgComponent,
    EmployeeItemComponent,
    EmployeeFilterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    MdButtonModule, 
    MdIconModule,
    MdSelectModule, 
    MdInputModule, 
    MdChipsModule, 
    MdTabsModule,
    MdProgressSpinnerModule,
    FlexLayoutModule,
    BrowserAnimationsModule
  ],
  providers: [EmployeeService, LocationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
