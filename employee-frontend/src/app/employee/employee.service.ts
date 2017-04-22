import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { Http, Headers, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/toPromise';

import { Employee } from './employee.model';

@Injectable()
export class EmployeeService {

  private emplo

  constructor(private http: Http) {

  }

  get(): Observable<Employee[]> {
    let url = "/api/employees/all";
    return this.http.get(url)
      .map(response => response.json());
  }

  add(employee: Employee): Observable<Employee> {
    let url = "/api/employees/";

    return this.http.post(url, employee)
      .map(response => response.json());
  }

}
