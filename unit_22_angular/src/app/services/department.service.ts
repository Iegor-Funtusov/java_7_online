import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {DepartmentModel} from "../models/department.model";

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  constructor(private _httpClient: HttpClient) { }

  loadDepartments(): Observable<DepartmentModel[]> {
    return this._httpClient.get('http://localhost:8080/api/departments') as Observable<DepartmentModel[]>;
  }
}
