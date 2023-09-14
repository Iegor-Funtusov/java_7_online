import {Routes} from "@angular/router";
import {DepartmentComponent} from "./department.component";
import {DepartmentNewComponent} from "./department-new/department-new.component";

export const DEPARTMENT_ROUTES: Routes = [
  {
    path: '',
    component: DepartmentComponent
  },
  {
    path: 'new',
    component: DepartmentNewComponent
  }
];
