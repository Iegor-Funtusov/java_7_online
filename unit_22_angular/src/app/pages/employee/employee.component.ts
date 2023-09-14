import {Component, OnInit} from '@angular/core';
import {EmployeeService} from "../../services/employee.service";
import {AsyncPipe, NgForOf} from "@angular/common";
import {Observable} from "rxjs";
import {EmployeeModel} from "../../models/employee.model";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss'],
  imports: [
    NgForOf,
    AsyncPipe
  ],
  standalone: true
})
export class EmployeeComponent implements OnInit {

  employees$: Observable<EmployeeModel[]> = this._employeeService.loadEmployees();

  constructor(private _employeeService: EmployeeService) { }

  ngOnInit(): void {

  }
}
