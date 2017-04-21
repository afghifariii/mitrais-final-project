import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EmployeeDetailComponent } from './employee-detail/employee-detail.component';
import { MdGridListModule, MdButtonModule, MdIconModule, MdCardModule } from "@angular/material";
import { EmployeeService } from "../shared/service/employee.service";
import { LocationService } from "../shared/service/location.service";
import { HttpModule } from '@angular/http';
import { EmployeeComponent } from './employee.component';

@NgModule({
  imports: [
    CommonModule,
    MdGridListModule,
    MdButtonModule,
    MdIconModule,
    MdCardModule
  ],
  providers: [EmployeeService, LocationService],
  declarations: [EmployeeComponent, EmployeeListComponent, EmployeeDetailComponent]
})
export class EmployeeModule { }
