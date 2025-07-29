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
		return flightBookingService.findUserFlightBooking(user);
	}
	//New Attempt at Method
	//Passing whole object down to service level for more options for functionality later.
	@GetMapping (value = "findUserFlightBookingByTravalDate",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findUserFlightBookingByTravalDate(@RequestParam User user, Date departure, Date arrival){ 
		return flightBookingService.findUserFlightBookingByTravalDate(user, departure, arrival);						//Or get flight object by bookingid?
//@RequestParam doesnt match the msql Query. So this needs two objects in the Request.
		
		//Annotation which indicates that a method parameter should be bound to a webrequest parameter. 

//Supported for annotated handler methods in Spring MVC and Spring WebFluxas follows: 
//•In Spring MVC, "request parameters" map to query parameters, form data,and parts in multipart requests. This is because the Servlet API combinesquery parameters and form data into a single map called "parameters", andthat includes automatic parsing of the request body. 
//•In Spring WebFlux, "request parameters" map to query parameters only.To work with all 3, query, form data, and multipart data, you can use databinding to a command object annotated with ModelAttribute. 
//
//If the method parameter type is Map and a request parameter nameis specified, then the request parameter value is converted to a Mapassuming an appropriate conversion strategy is available. 
//
//If the method parameter is Map<String, String> or MultiValueMap<String, String>and a parameter name is not specified, then the map parameter is populatedwith all request parameter names and values.

	}
	
	@GetMapping (value = "findBookingsOnFlight",produces = MediaType.APPLICATION_JSON_VALUE)					
	public List<FlightBooking> findBookingsOnFlight(@RequestParam Flight flight) {	
		return flightBookingService.findBookingsOnFlight(flight);
		//Should this be in booking service or flight service
		//I think it should stay here but something to think about.
	}
	
	@DeleteMapping(value = "deleteFlightBooking",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deleteFlightBooking(FlightBooking flightBooking) { 
		String deleteMessage = flightBookingService.deleteFlightBooking(flightBooking);
		return deleteMessage;
	}
	
	

}
