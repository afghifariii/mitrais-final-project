import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { MdDialog, MdDialogRef } from '@angular/material';

import { EmployeeService } from "../employee.service";
import { AppService } from "../../app.service";

import { EmployeeFilterComponent } from "../employee-filter/employee-filter.component";

import { Employee } from "../employee.model";
import { Location } from "../../location/location.model";

import { Subscription } from 'rxjs/Subscription';

@Component({
  selector: 'employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Employee[];
  selectedEmployee: Employee;
  selectedLocation: Location;
  isEdited: boolean = false;
  searchParam = "";
  gender = "";
  location = "";
  sortDir = "asc";
  isShow: boolean = false;
  subscription: Subscription;

  constructor(
    private employeeService: EmployeeService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private appService: AppService,
    private dialog: MdDialog
    ) { }

  ngOnInit() {
    this.employeeService.get()
      .subscribe(employees => {
        this.employees = employees;
        console.log(employees);
    });

    this.subscription = this.appService.notifyObservable$.subscribe((res) => {

      if (res.hasOwnProperty('option') && res.option === 'refresh') {

        this.getBy(this.searchParam, this.gender, this.location, this.sortDir);

      } else if (res.hasOwnProperty('option') && res.option === 'refreshSelected') {

        this.selectedEmployee = null;
        this.isEdited = false;

      } else if (res.hasOwnProperty('option') && res.option === 'refreshCancel') {

        this.selectedEmployee = null;
        this.isEdited = false;
      }
    });
  }

  getBy(searchParam, gender, location, sortDir) {
    console.log(searchParam, gender, location, sortDir)
    this.employeeService.getBy(searchParam, gender, location, sortDir)
      .subscribe(response => {
        this.employees = response;
        if (this.employees.length == 0) {
          this.isShow = true;
        } else {
          this.isShow = false;
        }
      })
  }

  onClick(employee) {
    this.isEdited = true;
    this.selectedEmployee = employee;
    this.selectedLocation = employee.location;
    this.router.navigate(["/employees", employee.empId]);
  }

  onChange(event) {
    this.searchParam = event.target.value;
    this.getBy(this.searchParam, this.gender, this.location, this.sortDir);
  }

  sortEmployee() {
    if (this.sortDir == "asc") {
      this.sortDir = "desc";
    } else {
      this.sortDir = "asc";
    }
    this.getBy(this.searchParam, this.gender, this.location, this.sortDir);
  }

  delete() {
    this.employeeService.delete(this.selectedEmployee.empId)
      .subscribe(empId => {
        this.selectedEmployee = null;
        this.isEdited = false;
        this.router.navigate(['/employees/']);
        this.getBy(this.searchParam, this.gender, this.location, this.sortDir);
      });
  }

  ngOnDestroy() {
    //Called once, before the instance is destroyed.
    //Add 'implements OnDestroy' to the class.
    this.subscription.unsubscribe();
  }

  filter(){
    let dialogRef = this.dialog.open(EmployeeFilterComponent, {
      height: '400px',
      width: '600px',
    });
    if (this.gender != "") {
      dialogRef.componentInstance.gender = this.gender;
      dialogRef.componentInstance.tempGender = this.gender;
      dialogRef.componentInstance.genderDisabled = true;
    }
    if (this.location != "") {
      dialogRef.componentInstance.location = this.location;
      dialogRef.componentInstance.tempLocation = this.location;
      dialogRef.componentInstance.locationDisabled = true;
    }
    dialogRef.afterClosed().subscribe(result => {
      if (result != undefined) {
        if (result.action == "filter") {
          this.location = result.locValue;
          this.gender = result.genderValue;
          this.getBy(this.searchParam, this.gender, this.location, this.sortDir);
        }
      }

    });

  }

}
