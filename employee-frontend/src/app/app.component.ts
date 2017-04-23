import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private selectedEmployee;
  private selectedLocation;

  onSelected(employee) {
    this.selectedEmployee = employee;
    this.selectedLocation = employee.location;
    
}
}