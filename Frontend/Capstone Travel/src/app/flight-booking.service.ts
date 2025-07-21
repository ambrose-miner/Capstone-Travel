import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class FlightBookingService {

  baseURL:string="http://localhost:8282/Capstone-Flight-Booking";
  
    constructor(public httpClient:HttpClient) { }
  
    findAllFlightBooking(flightBooking:any):Observable<string> {
      return this.httpClient.post(this.baseURL+ "/findAllFlightBooking",flightBooking,{responseType:'text'});
    }
    findUserFlightBooking(flightBooking:any):Observable<string> {
      return this.httpClient.post(this.baseURL+ "/findUserFlightBooking",flightBooking, {responseType: 'text'});
       
    }
    findUserFlightBookingByTravalDate(flightBooking:any):Observable<string> {
      return this.httpClient.post(this.baseURL+ "/findUserFlightBookingByTravalDate",flightBooking, {responseType: 'text'});
    }
    findFlightBookings(flightBooking:any):Observable<string> {
      return this.httpClient.post(this.baseURL+ "/findFlightBookings",flightBooking, {responseType: 'text'});
    }
    
}
