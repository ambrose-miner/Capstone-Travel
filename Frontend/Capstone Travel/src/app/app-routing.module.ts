import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginpageComponent } from './loginpage/loginpage.component';
import { FlightBookingComponent } from './flight-booking/flight-booking.component';
import { SignuppageComponent } from './signuppage/signuppage.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
const routes: Routes = [
  {path:'',component:LoginpageComponent},
  {path:"flight-booking",component:FlightBookingComponent},
  {path:"signuppage",component:SignuppageComponent},
  {path:"user-dashboard",component:UserDashboardComponent},
  {path:"admin-dashboard",component:AdminDashboardComponent},
  {path:'**' , redirectTo: ''}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
