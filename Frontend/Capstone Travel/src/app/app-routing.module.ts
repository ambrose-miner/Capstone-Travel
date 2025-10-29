import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginpageComponent } from './loginpage/loginpage.component';
import { FlightBookingComponent } from './flight-booking/flight-booking.component';
import { SignuppageComponent } from './signuppage/signuppage.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';

const routes: Routes = [
  { path: 'loginpage',component: LoginpageComponent },
  { path:'flight-booking', title: "Flight Booking" ,component: FlightBookingComponent },
  { path:'signuppage', title: "Sign Up" ,component: SignuppageComponent },
  { path:'user-dashboard', title: "Your Capstone" ,component: UserDashboardComponent },
  { path:'admin-dashboard', title: "Admin Hub" ,component: AdminDashboardComponent },
 // {path:'' , redirectTo: 'loginpage', pathMatch: 'full' ,component: LoginpageComponent}//Login is default route

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
