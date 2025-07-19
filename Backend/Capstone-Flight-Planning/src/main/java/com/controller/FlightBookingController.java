package com.controller;
import com.service.FlightBookingService;
import com.service.FlightService;

import java.sql.Date;
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
	
	@PostMapping(value = "bookFlight",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String bookFlight(@RequestBody FlightBooking flightBooking) {	
		System.out.println("Call book flight method");
		String Message = flightBookingService.bookFlight(flightBooking);
		 return Message;
	}
	
	@GetMapping(value = "findAllFlightBooking",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findAllFlightBooking() {
		return flightBookingService.findAllFlightBooking();
	}
	
	@GetMapping (value = "findUserFlightBooking",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findUserFlightBooking(@RequestParam User user) {
		return flightBookingService.findUserFlightBooking(user); //this is using the dot operator because the method findUserFlightBooking() is
																// a member of flightBookingService
	}
	//New Attempt at Method
	@GetMapping (value = "findUserFlightBookingByTravalDate",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findUserFlightBookingByTravalDate(@RequestParam User user, Flight flight){ //Will the front end need to pass ALL of the flight object?
		return flightBookingService.findUserFlightBookingByTravalDate(user, flight);
//Original Method	
//	@GetMapping (value = "findUserFlightBookingByTravalDate",produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<FlightBooking> findUserFlightBookingByTravalDate(@RequestParam User user, Flight departure, Flight arrival){
//		return flightBookingService.findUserFlightBookingByTravalDate(user, departure, arrival);
		
		//Notes on Original Method
		//public List<FlightBooking> findUserFlightBookingByTravalDate(@RequestParam User user, Date departure, Date arrival)
		// Like this? While declaring we are just telling it what data types and name not where its coming from...? 1 Object=User called user,
		// 1 date called departure, 1 date called arrival?
		
		//return flightBookingService.findUserFlightBookingByTravalDate(flightBooking.getUser(), flight.getDeparture(), flight.getArrival)
		//Like this? Or No this would be in the service method call because here is not where you do the getting this is the return of the values
		// with these names that is defined above...?
	}
	
	@GetMapping (value = "findFlightBookings",produces = MediaType.APPLICATION_JSON_VALUE)					
	public List<FlightBooking> findFlightBookings(@RequestParam Flight flight) {	
		return flightBookingService.findFlightBookings(flight);
		//Should this be in booking service or flight service
		//I think it should stay here but something to think about.
	}
	
	@DeleteMapping(value = "deleteFlightBooking",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deleteFlightBooking(FlightBooking flightBooking) { 
		String deleteMessage = flightBookingService.deleteFlightBooking(flightBooking);
		return deleteMessage;
	}
	
	

}
