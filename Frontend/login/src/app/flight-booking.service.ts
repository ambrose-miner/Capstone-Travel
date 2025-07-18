import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class FlightBookingService {

  baseURL:string="http://localhost:8282/Capstone-login";
  //this should be the correct path and port
    constructor(public httpClient:HttpClient) { }
  
    findAllFlightBooking(flightBooking:any):Observable<string> {//this does not need a login object.
      return this.httpClient.post(this.baseURL+ "/findAllFlightBooking",flightBooking,{responseType:'text'});
    }
    findUserFlightBooking(flightBooking:any):Observable<string> {
      return this.httpClient.post(this.baseURL+ "/findUserFlightBooking",flightBooking, {responseType: 'text'});
      //is this trying to pass the login object? So it should actually be a signUp object? 
    }
    findUserFlightBookingByTravalDate(flightBooking:any):Observable<string> {
      return this.httpClient.post(this.baseURL+ "/findUserFlightBookingByTravalDate",flightBooking, {responseType: 'text'});
    }
    findFlightBookings(flightBooking:any):Observable<string> {
      return this.httpClient.post(this.baseURL+ "/findFlightBookings",flightBooking, {responseType: 'text'});
    }
    
}
