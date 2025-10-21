import { Component } from '@angular/core';
import { Flight } from '../flight';
import { FlightBookingService } from '../flight-booking.service';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-flight-booking',
  templateUrl: './flight-booking.component.html',
  styleUrls: ['./flight-booking.component.css']
})
export class FlightBookingComponent {
searchFlight(): Array(Flight) {
FlightService.findAllFlights();
}
}
