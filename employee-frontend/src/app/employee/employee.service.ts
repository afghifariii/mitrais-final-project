import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { Http, Headers, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/toPromise';

import { Employee } from './employee.model';

@Injectable()
export class EmployeeService {

  private employee: Employee;

  constructor(private http: Http) {

  }

  get(): Observable<Employee[]> {
    let url = "/api/employees/all";
    return this.http.get(url)
      .map(response => response.json());
  }

  getOne(employee: Employee): Observable<Employee> {
    let url = "/api/employees/" + employee.empId;
    return this.http.get(url)
      .map(response => response.json());
  }

  add(employee: Employee): Observable<Employee> {
    let url = "/api/employees/";
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http.post(url, JSON.stringify(employee), { headers: headers })
      .map(response => response.json());
  }

  put(employee: Employee): Observable<Employee> {
    let url = "/api/employees/" + employee.empId;
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http.put(url, JSON.stringify(employee), { headers: headers })
      .map(response => response.json());
  }

}
