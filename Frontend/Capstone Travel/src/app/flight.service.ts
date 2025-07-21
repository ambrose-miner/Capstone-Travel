import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class FlightService {
baseURL:string="http://localhost:8282/Capstone-Flight-Booking";
  constructor(public httpClient:HttpClient) { }

findAllFlights(flight:any):Observable<string> {
      return this.httpClient.post(this.baseURL+ "/findAllFlights",flight,{responseType:'text'});
    }
findFlight(flight:any):Observable<string> {
      return this.httpClient.post(this.baseURL+ "/findFlight",flight,{responseType:'text'});
    }
searchFlightsByPlan(flight:any):Observable<string> {
      return this.httpClient.post(this.baseURL+ "/searchFlightsByPlan",flight,{responseType:'text'});
    }
searchFlightsByPlanAndDepartureDate(flight:any):Observable<string> {
      return this.httpClient.post(this.baseURL+ "/searchFlightsByPlanAndDepartureDate",flight,{responseType:'text'});
    }
searchFlightsByPlanAndArrivalDate(flight:any):Observable<string> {
      return this.httpClient.post(this.baseURL+ "/searchFlightsByPlanAndArrivalDate",flight,{responseType:'text'});
    }
}
