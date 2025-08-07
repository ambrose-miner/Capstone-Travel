package com.controller;
import com.service.FlightBookingService;
import com.service.FlightService;



import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
//import jakarta.persistence.Id;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bean.User;
import com.bean.Flight;
import com.bean.FlightBooking;
import com.bean.Login;
@CrossOrigin
@RestController

public class FlightBookingController {
	
	@Autowired
	FlightBookingService flightBookingService;
	@Autowired
	RestTemplate restTemplate;
	
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
	public List<FlightBooking> findUserFlightBooking(@RequestParam Long userid) {
		String url = "http://localhost:8181/Capstone-Login/signIn/" + userid;		
		restTemplate.getForObject(url, Login.class);	//I still cant get this part to work. 
														//Do I need a copy of class Login in flight booking or use User class
														//and have a copy of User class in login.
		return flightBookingService.findUserFlightBooking(userid);
	}
	

	//The intent of this method is to find flightbooking by travel dates but maybe this is not needed just find user flights.
	//This method has been commented out through out. It breaks the build.
//	@GetMapping (value = "findUserFlightBookingByTravalDate",produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<FlightBooking> findUserFlightBookingByTravalDate(@RequestParam User user, Date departure, Date arrival){ 
//		return flightBookingService.findUserFlightBookingByTravalDate(user, departure, arrival);
//	}

	
	
	@GetMapping (value = "findBookingsOnFlight",produces = MediaType.APPLICATION_JSON_VALUE)					
	public List<FlightBooking> findBookingsOnFlight(@RequestParam Flight flight) {	
		return flightBookingService.findBookingsOnFlight(flight);
	}
	
	@DeleteMapping(value = "deleteFlightBooking",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deleteFlightBooking(FlightBooking flightBooking) { 
		String deleteMessage = flightBookingService.deleteFlightBooking(flightBooking);
		return deleteMessage;
	}
	
	

}
