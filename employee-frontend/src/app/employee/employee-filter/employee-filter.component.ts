import { Component, OnInit } from '@angular/core';

import { MdDialog, MdDialogRef } from '@angular/material';

import { LocationService } from "../../location/location.service";
import { Location } from "../../location/location.model";

@Component({
  selector: 'employee-filter',
  templateUrl: './employee-filter.component.html',
  styleUrls: ['./employee-filter.component.css']
})
export class EmployeeFilterComponent implements OnInit {
  private locations: Location[];
  genderArr = ["Male", "Female"];
  genderDisabled = false; 
  locationDisabled = false; 
  gender = "";
  tempGender = "";
  location = "";
  tempLocation = "";

  constructor(
    public dialogRef: MdDialogRef<EmployeeFilterComponent>,
    private locationService: LocationService) { }

  ngOnInit() {
    this.locationService.get()
      .subscribe(response => this.locations = response);

  }

  onLocationClick() {
    if (this.locationDisabled == true) {
      this.location = "";
    } else {
      this.location = this.tempLocation;
    }
  }

  onLocationChange(event) {
    this.location = event.value;
    this.tempLocation = event.value;
  }

  onGenderClick() {
    if (this.genderDisabled == true) {
      this.gender = "";
    } else {
      this.gender = this.tempGender;
    }
  }
  onGenderChange(event) {
    this.gender = event.value;
    this.tempGender = event.value;
  }

}
