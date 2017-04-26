import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { ReactiveFormsModule } from '@angular/forms';

import { MdButtonModule, MdCheckboxModule, MdIconModule, MdInputModule, MdChipsModule, MdTabsModule, MdProgressSpinnerModule, MdSelectModule, MdDialogModule } from "@angular/material";
import { FlexLayoutModule } from '@angular/flex-layout';

import { EmployeeListComponent } from "./employee/employee-list/employee-list.component";
import { EmployeeDetailComponent } from './employee/employee-detail/employee-detail.component';
import { AppComponent } from './app.component';

import { EmployeeService } from "./employee/employee.service";
import { LocationService } from "./location/location.service";
import { BtnSvgComponent } from './btn-svg/btn-svg.component';
import { EmployeeItemComponent } from './employee/employee-item/employee-item.component';
import { EmployeeFilterComponent } from './employee/employee-filter/employee-filter.component';
import { AppService } from './app.service';
import { routing } from "./app.routing";


@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    EmployeeDetailComponent,
    BtnSvgComponent,
    EmployeeItemComponent,
    EmployeeFilterComponent
  ],
  entryComponents: [
    EmployeeFilterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    MdButtonModule,
    MdIconModule,
    MdDialogModule,
    MdCheckboxModule,
    MdSelectModule,
    MdInputModule,
    MdChipsModule,
    MdTabsModule,
    MdProgressSpinnerModule,
    FlexLayoutModule,
    BrowserAnimationsModule,
    routing
  ],
  providers: [EmployeeService, LocationService, AppService],
  bootstrap: [AppComponent]
})
export class AppModule { }
