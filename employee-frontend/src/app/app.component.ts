import { Component } from '@angular/core';
import { Employee } from "./employee/employee.model";
import { Location } from "./location/location.model";
import { AppService } from "./app.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private selectedEmployee: Employee;
  private selectedLocation: Location;

  constructor(private appService: AppService){}

  onSelected(employee: Employee) {
    this.selectedEmployee = employee;
    this.selectedLocation = employee.location;
  }

  add() {
    this.appService.notifyOther({ option: 'refreshSelected', value: 'new' });
  }
}