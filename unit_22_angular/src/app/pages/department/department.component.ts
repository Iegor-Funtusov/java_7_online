import { Component } from '@angular/core';
import {DepartmentService} from "../../services/department.service";
import {Observable} from "rxjs";
import {DepartmentModel} from "../../models/department.model";
import {AsyncPipe, NgForOf} from "@angular/common";

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.scss'],
  imports: [
    AsyncPipe,
    NgForOf
  ],
  standalone: true
})
export class DepartmentComponent {

  departments$: Observable<DepartmentModel[]> = this._departmentService.loadDepartments();

  constructor(private _departmentService: DepartmentService) {
  }
}
