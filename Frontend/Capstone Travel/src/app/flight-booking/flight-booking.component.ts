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
searchFlight(): Observable<string> {
return this.flightService.findAllFlights();
//Property 'findAllFlights' does not exist on type 'typeof FlightService'
//Error on findAllFlights
}
}
