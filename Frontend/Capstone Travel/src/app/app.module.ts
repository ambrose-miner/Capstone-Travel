import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, ROUTES } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { LoginpageComponent } from './loginpage/loginpage.component';
import { SignuppageComponent } from './signuppage/signuppage.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { RideBookingComponent } from './ride-booking/ride-booking.component';
import { FlightBookingComponent } from './flight-booking/flight-booking.component';
import { bootstrapApplication } from '@angular/platform-browser';
import { provideRouter, RouterOutlet, Router, RouterLink, withHashLocation } from '@angular/router';
import { AppComponent } from './app.component';
@NgModule({
  declarations: [
    AppComponent,
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
    RouterModule

  ],
  bootstrap: [AppComponent]
})

export class AppModule { 
  constructor(private router: Router){}
  navigateToLogin(){
    this.router.navigate(['/app.component.ts']);
  }
  provideRouter(){
    return Router;
  }
}
