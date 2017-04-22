import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { Http, Headers, RequestOptions } from '@angular/http';
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

  post(employee): Observable<Employee> {
    let body = JSON.stringify(employee);
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    let url = "/api/employees/";

    return this.http.post(url, body, options)
      .map(response => response.json());
  }

}
