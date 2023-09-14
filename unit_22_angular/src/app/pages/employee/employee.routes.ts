import {Routes} from "@angular/router";
import {EmployeeComponent} from "./employee.component";
import {EmployeeNewComponent} from "./employee-new/employee-new.component";

export const EMPLOYEE_ROUTES: Routes = [
  {
    path: '',
    component: EmployeeComponent
  },
  {
    path: 'new',
    component: EmployeeNewComponent
  }
];
