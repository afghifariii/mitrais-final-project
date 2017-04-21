import { Component, OnInit } from '@angular/core';

import { EmployeeService } from "../employee.service";
import { Employee } from "../employee.model";

@Component({
  selector: 'employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  private employees : Employee[];

  constructor(private employeeService: EmployeeService) { }

  ngOnInit() {
    this.employeeService.get()
    .subscribe(response => this.employees = response);
  }

}
