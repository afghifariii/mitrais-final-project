import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';

import { Employee } from '../employee.model';
import { EmployeeService } from '../employee.service';
import { Location } from "../../location/location.model";

@Component({
  selector: 'employee-item',
  templateUrl: './employee-item.component.html',
  styleUrls: ['./employee-item.component.css']
})
export class EmployeeItemComponent implements OnInit {

  @Input() employee: Employee;
  @Input() selectedEmployee: Employee;

  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit() {
  }

  isSelected() {
    let state = false;
    if (this.employee != null && this.selectedEmployee != null) {
      if (this.employee.empId === this.selectedEmployee.empId) {
        state = true;
      }
    }
    return state;
  }

  setImage() {
    if (this.employee.photo == null) {
      return "src/resources/images/no-image.png";
    } else {
      return this.employee.photo;
    }
  }

  onSelect() {
    this.router.navigate(['/employees', this.employee.empId]);
  }

}
