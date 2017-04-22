import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

import { EmployeeService } from "../employee.service";
import { Employee } from "../employee.model";

@Component({
  selector: 'employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  @Output() show = new EventEmitter();
  private employees: Employee[];

  constructor(private employeeService: EmployeeService) { }

  ngOnInit() {
    this.employeeService.get()
      .subscribe(response => this.employees = response);
  }

  onSelect(employee) {
    console.log(employee);
    this.show.emit(employee);
  }

}
