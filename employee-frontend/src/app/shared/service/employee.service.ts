import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';

import { Employee } from '../model/employee.model';

@Injectable()
export class EmployeeService {

  private url;

  constructor(private http: Http) {
    this.url = '/api/employees/';
  }

  get(): Observable<Employee[]> {
    return this.http.get(this.url)
      .map(response => response.json());
  }

}
