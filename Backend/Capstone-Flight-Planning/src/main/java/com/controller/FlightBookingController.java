package com.controller;
import com.service.FlightBookingService;
import com.service.FlightService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bean.User;
import com.bean.Flight;
import com.bean.FlightBooking;
@CrossOrigin
@RestController
public class FlightBookingController {
	@Autowired
	FlightBookingService flightBookingService;
	
	@GetMapping(value = "findAllFlightBooking",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findAllFlightBooking() {
		return flightBookingService.findAllFlightBooking();
	}
	@GetMapping (value = "findUserFlightBooking",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findUserFlightBooking(@RequestParam User user) { //passing user object to find user's flightBookings.
		return flightBookingService.findUserFlightBooking(user);
	}
	@GetMapping (value = "findUserFlightBookingByTravalDate",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findUserFlightBookingByTravalDate(@RequestParam User user, Flight departure, Flight arrival){
		return flightBookingService.findUserFlightBookingByTravalDate(user, departure, arrival);
	}
	@GetMapping (value = "findFlightBookings",produces = MediaType.APPLICATION_JSON_VALUE)//Should this be in booking service or flight service																			
	public List<FlightBooking> findFlightBookings(@RequestParam Flight flight) {//I think it should stay here but something to think about.	
		return flightBookingService.findFlightBookings(flight);
	}
	@DeleteMapping(value = "deleteFlightBooking",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deleteFlightBooking(FlightBooking flightBooking) { 
		String deleteMessage = flightBookingService.deleteFlightBooking(flightBooking);
		return deleteMessage;
	}
	
	@PostMapping(value = "bookFlight",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String bookFlight(@RequestBody FlightBooking flightBooking) {	
		System.out.println("Call book flight method");
		String Message = flightBookingService.bookFlight(flightBooking);
		 return Message;
	}


}
