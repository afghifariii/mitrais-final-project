import { Routes, RouterModule } from '@angular/router';

import { EmployeeDetailComponent } from './employee/employee-detail/employee-detail.component';
// import { ReportItemComponent } from './report-item.component';

const appRoutes: Routes = [
  // { path: 'employees/add', component: EmployeeFormComponent },
  // { path: 'report', component: ReportItemComponent },
  { path: 'employees/:id', component: EmployeeDetailComponent },
  { path: 'employees', pathMatch: 'full', redirectTo: 'employees/' },
  { path: '', pathMatch: 'full', redirectTo: 'employees/' }
];

export const routing = RouterModule.forRoot(appRoutes);