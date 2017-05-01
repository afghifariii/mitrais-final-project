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

  employee: Employee = new Employee("","","","",null,"","","","",null,null,"","","","","",new Location("", ""));
  location: Location;
  private locations: Location[];
  private form;
  private isShow = false;
  private isEdited = false
  private empId;
  private empPhoto = "";
  genderArr = ["Male", "Female"];
  gradeArr = ["SE - JP", "SE - PG", "SE - AP", "SE - AN"];
  divisionArr = ["SWD - TechOne", "CDC - TechOne", "MMS - TechOne", "CDC - Red", "CDC - Services", "MMS - Services", "SWD - Services", "SWD - Blue"];
  maritalArr = ["Single", "Married"];
  image;
   

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
        if (this.empId == "new") {
          this.isEdited = false;
          this.isShow = true;
          this.empPhoto = "src/resources/images/no-image.png"
          this.form.reset();
        } else if (this.empId != null && this.empId != "") {
          this.getOne(this.empId);
        }

      });

  }

  chooseImage(event) {
    this.image = event.target.files;
    //console.log(this.image[0]);

    var reader = new FileReader();
    reader.onload = (event: any) => {
      this.empPhoto = event.target.result;
      //console.log(this.empPhoto);
    }
    
    reader.readAsDataURL(event.target.files[0]);

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
      empId         : this.formBuilder.control(this.employee.empId),
      firstName     : this.formBuilder.control(this.employee.firstName, Validators.compose([Validators.required, Validators.pattern('[\\w\\-\\s\\/]+')])),
      lastName      : this.formBuilder.control(this.employee.lastName, Validators.compose([Validators.required, Validators.pattern('[\\w\\-\\s\\/]+')])),
      gender        : this.formBuilder.control(this.employee.gender, Validators.compose([Validators.required])),
      dateOfBirth   : this.formBuilder.control(this.employee.dateOfBirth, Validators.compose([Validators.required])),
      nationality   : this.formBuilder.control(this.employee.nationality, Validators.compose([Validators.required])),
      maritalStatus : this.formBuilder.control(this.employee.maritalStatus, Validators.compose([Validators.required])),
      phone         : this.formBuilder.control(this.employee.phone, Validators.compose([Validators.required, Validators.pattern(/^[0-9\(\)\-\+]{5,25}$/)])),
      location      : this.formBuilder.control(this.employee.location.id, Validators.compose([Validators.required])),
      subDivision   : this.formBuilder.control(this.employee.subDivision, Validators.compose([Validators.required])),
      status        : this.formBuilder.control(this.employee.status, Validators.compose([Validators.required])),
      suspendDate   : this.formBuilder.control(this.employee.suspendDate),
      hiredDate     : this.formBuilder.control(this.employee.hiredDate, Validators.compose([Validators.required])),
      grade         : this.formBuilder.control(this.employee.grade, Validators.compose([Validators.required])),
      division      : this.formBuilder.control(this.employee.division, Validators.compose([Validators.required])),
      email         : this.formBuilder.control(this.employee.email, Validators.compose([Validators.required, Validators.pattern(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)]))
    });
  }

  initValues() {
    this.form = this.formBuilder.group({
      empId         : this.formBuilder.control(''),
      firstName     : this.formBuilder.control('', Validators.compose([Validators.required, Validators.pattern('[\\w\\-\\s\\/]+')])),
      lastName      : this.formBuilder.control('', Validators.compose([Validators.required, Validators.pattern('[\\w\\-\\s\\/]+')])),
      gender        : this.formBuilder.control('', Validators.compose([Validators.required])),
      dateOfBirth   : this.formBuilder.control('', Validators.compose([Validators.required])),
      nationality   : this.formBuilder.control('', Validators.compose([Validators.required])),
      maritalStatus : this.formBuilder.control('', Validators.compose([Validators.required])),
      phone         : this.formBuilder.control('', Validators.compose([Validators.required, Validators.pattern(/^[0-9\(\)\-\+]{5,25}$/)])),
      location      : this.formBuilder.control('', Validators.compose([Validators.required])),
      subDivision   : this.formBuilder.control('', Validators.compose([Validators.required])),
      status        : this.formBuilder.control('', Validators.compose([Validators.required])),
      suspendDate   : this.formBuilder.control(''),
      hiredDate     : this.formBuilder.control('', Validators.compose([Validators.required])),
      grade         : this.formBuilder.control('', Validators.compose([Validators.required])),
      division      : this.formBuilder.control('', Validators.compose([Validators.required])),
      email         : this.formBuilder.control('', Validators.compose([Validators.required, Validators.pattern(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)]))
    });
    this.empPhoto = "src/resources/images/no-image.png";
  }

  save(employee: Employee) {
    const location: Location = {
      id: this.employee.location.id,
      city: ''
    };
    employee.location = location;

    if(this.empPhoto != "src/resources/images/no-image.png" && this.empPhoto != null){
      employee.photo = this.empPhoto;
    }

    this.employeeService.postOrPut(employee, this.empId)
    .subscribe(response => {
      //console.log(response);
      this.refresh();
    })
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
          if (this.employee.photo == null){
            this.empPhoto = "src/resources/images/no-image.png";
          }else{
            this.empPhoto = response.photo;
          }
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

  onChange(location: Location) {
    if(this.employee.location != null){
      this.employee.location = location;
    }
    //console.log(this.employee.location)
  }

}
