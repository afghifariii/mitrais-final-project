import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Validators, FormBuilder } from '@angular/forms'

import { EmployeeService } from "../employee.service";
import { LocationService } from "../../location/location.service";

import { Employee } from "../employee.model";
import { Location } from "../../location/location.model";


@Component({
  selector: 'employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.css']
})
export class EmployeeDetailComponent implements OnInit {

  @Input() employee;
  
  private locations: Location[];
  private form;

  constructor(
    private employeeService: EmployeeService,
    private locationService: LocationService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit() {
    this.locationService.get()
      .subscribe(response => this.locations = response);

    this.validation();

  }

  validation() {
    this.form = this.formBuilder.group({
      id: this.formBuilder.control(this.employee.id),
      firstName: this.formBuilder.control(this.employee.firstName),
      lastName: this.formBuilder.control(this.employee.lastName),
      gender: this.formBuilder.control(this.employee.gender),
      dateOfBirth: this.formBuilder.control(this.employee.dateOfBirth),
      nationality: this.formBuilder.control(this.employee.nationality),
      maritalStatus: this.formBuilder.control(this.employee.maritalStatus),
      phone: this.formBuilder.control(this.employee.phone),
      location: this.formBuilder.control(this.employee.location),
      subDivision: this.formBuilder.control(this.employee.subDivision),
      status: this.formBuilder.control(this.employee.status),
      suspendDate: this.formBuilder.control(this.employee.suspendDate),
      hiredDate: this.formBuilder.control(this.employee.hiredDate),
      grade: this.formBuilder.control(this.employee.grade),
      division: this.formBuilder.control(this.employee.division),
      email: this.formBuilder.control(this.employee.email),
    });
  }
  
  add(employee) {
    this.employeeService.post(employee)
      .subscribe(response => this.employee = response);
  }

}
