import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { ContactComponent } from './components/contact/contact.component';
import { LoginComponent } from './components/login/login.component';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';

const routes: Routes = [
  { path: "", redirectTo: "dashboard", pathMatch: "full" }, 
  { path: "dashboard", component: DashboardComponent }, 
  { path: "contact", component: ContactComponent }, 
  { path: "admin/login", component: LoginComponent }, 
  { path: "admin/dashboard", component: AdminDashboardComponent }, 

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
