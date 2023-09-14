import {Routes} from '@angular/router';

export const APP_ROUTES: Routes = [
  {
    path: '',
    redirectTo: 'employees',
    pathMatch: 'full'
  },
  {
    path: 'employees',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/employee/employee.routes').then(m => m.EMPLOYEE_ROUTES)
  },
  {
    path: 'departments',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/department/department.routes').then(m => m.DEPARTMENT_ROUTES)
  }
];
