import { Component, OnInit } from '@angular/core';

import { EmployeeService } from "./employee.service";
import { Employee } from "./employee.model";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  private employees : Employee[];

  constructor(private employeeService: EmployeeService) {}

  ngOnInit() {
    this.employeeService.get()
    .subscribe(response => this.employees = response);
  }

}
