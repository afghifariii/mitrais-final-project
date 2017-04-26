import { Component, OnInit, Input, Output, EventEmitter, OnChanges, SimpleChange } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Validators, FormBuilder, ReactiveFormsModule } from '@angular/forms';

import { EmployeeService } from "../employee.service";
import { LocationService } from "../../location/location.service";
import { AppService } from "../../app.service";

import { Employee } from "../employee.model";
import { Location } from "../../location/location.model";


@Component({
  selector: 'employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.css']
})
export class EmployeeDetailComponent implements OnInit {

  employee: Employee;
  location: Location;
  private locations: Location[];
  private form;
  private isShow = false;
  private isEdited = false
  private empId;
  private empPhoto="";

  constructor(
    private employeeService: EmployeeService,
    private locationService: LocationService,
    private formBuilder: FormBuilder,
    private appService: AppService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit() {
    this.locationService.get()
      .subscribe(response => this.locations = response);

    this.initValues();

    this.activatedRoute.params
      .subscribe(params => {
        this.empId = params['id'];
        this.isShow = false;
        if (this.empId == "add") {
          this.isEdited = false;
          this.isShow = true;
          this.form.reset();
        } else if (this.empId != null && this.empId != "") {
          this.getOne(this.empId);
        }

      });

  }

  // ngOnChanges(changes: { [propKey: string]: SimpleChange }) {
  //   //Called before any other lifecycle hook. Use it to inject dependencies, but avoid any serious work here.
  //   //Add 'implements OnChanges' to the class.
  //   this.employeeService.getOne(changes.employee.currentValue)
  //     .subscribe(res => this.employee = res);

  //   this.setValues();
  // }


  setValues() {
    this.form = this.formBuilder.group({
      // empId: this.formBuilder.control(this.employee.empId),
      firstName: this.formBuilder.control(this.employee.firstName),
      lastName: this.formBuilder.control(this.employee.lastName),
      gender: this.formBuilder.control(this.employee.gender),
      dateOfBirth: this.formBuilder.control(this.employee.dateOfBirth),
      nationality: this.formBuilder.control(this.employee.nationality),
      maritalStatus: this.formBuilder.control(this.employee.maritalStatus),
      phone: this.formBuilder.control(this.employee.phone),
      location: this.formBuilder.control(this.employee.location.id),
      subDivision: this.formBuilder.control(this.employee.subDivision),
      status: this.formBuilder.control(this.employee.status),
      suspendDate: this.formBuilder.control(this.employee.suspendDate),
      hiredDate: this.formBuilder.control(this.employee.hiredDate),
      grade: this.formBuilder.control(this.employee.grade),
      division: this.formBuilder.control(this.employee.division),
      email: this.formBuilder.control(this.employee.email)
    });
  }

  initValues() {
    this.form = this.formBuilder.group({
      // empId: this.formBuilder.control(''),
      firstName: this.formBuilder.control(''),
      lastName: this.formBuilder.control(''),
      gender: this.formBuilder.control(''),
      dateOfBirth: this.formBuilder.control(''),
      nationality: this.formBuilder.control(''),
      maritalStatus: this.formBuilder.control(''),
      phone: this.formBuilder.control(''),
      location: this.formBuilder.control(''),
      subDivision: this.formBuilder.control(''),
      status: this.formBuilder.control(''),
      suspendDate: this.formBuilder.control(''),
      hiredDate: this.formBuilder.control(''),
      grade: this.formBuilder.control(''),
      division: this.formBuilder.control(''),
      email: this.formBuilder.control('')
    });
  }

  save(employee: Employee) {
    
    const location : Location = {
      id: this.employee.location.id,
      city: ''
    };
    employee.location = location;
    console.log('sv',employee);
    if (!employee.empId) {
      this.employeeService.add(employee)
        .subscribe(response => {
          this.employee = response;
          this.refresh();
        });
    } else {
      this.employeeService.put(employee)
        .subscribe(response => {
          this.employee = response;
          this.refresh();
        });
    }
  }

  getOne(empId) {
    this.employeeService.getOne(empId)
      .subscribe(response => {
        this.employee = response;
        if (this.employee == null) {
          this.isShow = false;
        } else {
          this.isShow = true;
          this.isEdited = true;
          this.setValues();
        }
      })
  }

  cancel() {
    this.initValues();
    this.appService.notifyOther({ option: 'refreshCancel', value: 'cancel' });
    this.router.navigate(['/employees/']);
  }

  refresh() {
    this.appService.notifyOther({ option: 'refresh', value: 'from form' });
    this.router.navigate(['/employees/']);
  }

  onChange(location: Location){
    this.employee.location = location;
    console.log(this.employee.location)
  }

}
