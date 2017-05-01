import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { Http, Headers, RequestOptions, URLSearchParams } from '@angular/http';
import 'rxjs/add/operator/toPromise';

import { Employee } from './employee.model';
import { Location } from "../location/location.model";

@Injectable()
export class EmployeeService {

  private employee: Employee;

  constructor(private http: Http) {

  }

  get(): Observable<Employee[]> {
    let url = "/api/employees/all";
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.get(url, { headers: headers })
      .map(response => response.json());
  }

  getBy(searchParam, gender, location, sort): Observable<Employee[]> {
    let url = "/api/employees/getby";

    let headers = new Headers();
    headers.append('Content-Type', 'application/json');

    let searchParams = new URLSearchParams();
    searchParams.append('firstName', searchParam);
    searchParams.append('lastName', searchParam);
    searchParams.append('gender', gender);
    searchParams.append('location', location);
    searchParams.append('sort', sort);

    return this.http.get(url, { search: searchParams, headers: headers })
      .map(response => response.json());
  }

  getOne(empId): Observable<Employee> {
    let url = "/api/employees/" + empId;
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.get(url, { headers: headers })
      .map(response => {
        if (response != null) {
          return response.json();
        } else {
          return null
        }
      });
  }

  postOrPut(employee: Employee, empId): Observable<Employee> {

    let headers = new Headers();
    headers.append('Content-Type', 'application/json');

    if (empId != 'new' && empId != null && empId != undefined) {
      let url = "/api/employees/" + employee.empId;
      return this.http.put(url, JSON.stringify(employee), { headers: headers })
        .map(response => response.json());
    } else {
      let url = "/api/employees/";
      return this.http.post(url, JSON.stringify(employee), { headers: headers })
        .map(response => response.json());
    }

  }

  delete(empId) {
    let url = "/api/employees/" + empId;

    return this.http.delete(url)
      .map(response => response);
  }

}
