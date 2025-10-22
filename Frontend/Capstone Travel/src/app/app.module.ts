import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, ROUTES } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginpageComponent } from './loginpage/loginpage.component';
import { SignuppageComponent } from './signuppage/signuppage.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { RideBookingComponent } from './ride-booking/ride-booking.component';
import { FlightBookingComponent } from './flight-booking/flight-booking.component';
import { bootstrapApplication } from '@angular/platform-browser';
@NgModule({
  declarations: [
   // AppComponent,
    LoginpageComponent,
    SignuppageComponent,
    AdminDashboardComponent,
    UserDashboardComponent,
    RideBookingComponent,
    FlightBookingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserModule,
    RouterModule

  ],
})
  // providers: [],
  // bootstrap: [AppComponent]
export class AppModule { }
