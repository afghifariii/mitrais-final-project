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

  getBy(searchParam, gender, location, sort): Observable<Employee[]> {
    let url = "/api/employees/getby";

    let searchParams = new URLSearchParams();
    searchParams.append('firstName', searchParam);
    searchParams.append('lastName', searchParam);
    searchParams.append('gender', gender);
    searchParams.append('location', location);
    searchParams.append('sort', sort);

    return this.http.get(url, { search: searchParams })
      .map(response => response.json());
  }

  getOne(empId): Observable<Employee> {
    let url = "/api/employees/" + empId;
    return this.http.get(url)
      .map(response => {
        if (response != null) {
          return response.json();
        } else {
          return null
        }
      });
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

  delete(empId) {
    let url = "/api/employees/" + empId;

    return this.http.delete(url)
      .map(response => response);
  }

}
