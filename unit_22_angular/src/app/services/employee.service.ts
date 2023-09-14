import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {EmployeeModel} from "../models/employee.model";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private _httpClient: HttpClient) { }

  loadEmployees(): Observable<EmployeeModel[]> {
    return this._httpClient.get('http://localhost:8080/api/employees') as Observable<EmployeeModel[]>;
  }
}
