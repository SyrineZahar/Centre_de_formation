import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { ContactComponent } from './components/contact/contact.component';
import { LoginComponent } from './components/login/login.component';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { AddEditFormationComponent } from './components/add-edit-formation/add-edit-formation.component';
import { authGuard } from './guard/auth.guard';
import { ErrorComponent } from './components/error/error.component';

const routes: Routes = [
  { path: "", redirectTo: "dashboard", pathMatch: "full" }, 
  { path: "dashboard", component: DashboardComponent }, 
  { path: "contact", component: ContactComponent }, 
  { path: "admin/login", component: LoginComponent }, 
  { path: "admin/dashboard", component: AdminDashboardComponent, canActivate: [authGuard]  }, 
  { path: "admin/formation", component: AddEditFormationComponent, canActivate: [authGuard]  }, 
  { path: 'admin/formation/:id', component: AddEditFormationComponent, canActivate: [authGuard]  } ,
  { path: '**', component: ErrorComponent } 


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
