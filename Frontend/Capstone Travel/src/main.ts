import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app/app.module';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app/app-routing.module';
import { AppComponent } from './app/app.component';
import { LoginpageComponent } from './app/loginpage/loginpage.component';
import { AdminDashboardComponent } from './app/admin-dashboard/admin-dashboard.component';
import { UserDashboardComponent } from './app/user-dashboard/user-dashboard.component';
import { FlightBookingComponent } from './app/flight-booking/flight-booking.component';
import { SignuppageComponent } from './app/signuppage/signuppage.component';


//@NgModule({
  //declarations: [
  //LoginpageComponent,
  //AdminDashboardComponent,
  //UserDashboardComponent,
  //FlightBookingComponent,
  //SignuppageComponent,
 // ],
  //imports:[
   // BrowserModule,
  //  AppRoutingModule
  //],
  
//})


 platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
