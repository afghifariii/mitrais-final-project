import { Component } from '@angular/core';
import { Employee } from "./employee/employee.model";
import { Location } from "./location/location.model";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private selectedEmployee: Employee;
  private selectedLocation: Location;

  onSelected(employee: Employee) {
    this.selectedEmployee = employee;
    this.selectedLocation = employee.location;
  }
}