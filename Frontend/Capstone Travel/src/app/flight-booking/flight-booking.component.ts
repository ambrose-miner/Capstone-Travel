import { Component } from '@angular/core';
import { Flight } from '../flight';
import { FlightBookingService } from '../flight-booking.service';
import { FlightService } from '../flight.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-flight-booking',
  templateUrl: './flight-booking.component.html',
  styleUrls: ['./flight-booking.component.css']
})
export class FlightBookingComponent {
  constructor(private flightService: FlightService){}

findAllFlights(): Observable<string> {
return this.flightService.findAllFlights();
//Why does it only allow this one to be Observable<Object> but bellow 
//can be Observable<string>????
}
searchFlightsByPlan(flight:any): Observable<string> {
  return this.flightService.searchFlightsByPlan(flight);
}
searchFlightsByPlanAndDepartureDate(flight:any): Observable<string> {
  return this.flightService.searchFlightsByPlan(flight);
}
searchFlightsByPlanAndArrivalDate(flight:any): Observable<string> {
  return this.flightService.searchFlightsByPlan(flight);
}
}
