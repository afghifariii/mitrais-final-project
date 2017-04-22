import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';

import { Employee } from './employee.model';

@Injectable()
export class EmployeeService {

  constructor(private http: Http) {
    
  }

  get(): Observable<Employee[]> {
    let url = "/api/employees/all";
    return this.http.get(url)
      .map(response => response.json());
  }

}
