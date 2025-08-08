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
		String url = "http://localhost:8181/Capstone-Login/signIn/" + userid;	//This is needed to for the rest template to call the endpoint.	
		restTemplate.getForObject(url, Login.class);	//This should be able to take that info from the rest template addressing
														//the class Login that has a userid and pass that info.
		
		//I still cant get this part to work. It wants there to be a login class here in this microservice or to make the other
		//microservice a dependency which defeats the whole point of it being a microservice.
		//Do I need a copy of class Login in flight booking or use User class and have a copy of User class in login. The Classes in the Login
		//and those in User are different but shouldn't need to be the same.
		//
		return flightBookingService.findUserFlightBooking(userid);
	}
	
	
	//The intent of this method is to find flightbooking by travel dates but maybe this is not needed just find user flights.
	//This method has been commented out through out. It breaks the build.
	
	@GetMapping (value = "findUserFlightBookingByTravalDate",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findUserFlightBookingByTravalDate(
			@RequestParam (value = "userid", required = true) Long userid,
			@RequestParam (value = "departure", required = false) Date departure, 
			@RequestParam (value = "arrival", required = false) Date arrival){ 
				String url = "http://localhost:8181/Capstone-Login/signIn/" + userid;
				restTemplate.getForObject(url, Login.class);
		return flightBookingService.findUserFlightBookingByTravalDate(userid, departure, arrival);//still same problem as above....
	}

	
	
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
