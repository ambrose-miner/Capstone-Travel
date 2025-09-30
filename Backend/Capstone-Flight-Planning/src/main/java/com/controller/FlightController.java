package com.controller;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Flight;
import com.bean.FlightBooking;
import com.bean.User;
import com.service.FlightService;
@CrossOrigin
@RestController
@RequestMapping("/flight")
public class FlightController {
	
	@Autowired FlightService flightService;
	
	@PostMapping(value = "/createFlight",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createFlight(@RequestBody Flight newFlight) {
		 System.out.println("Call book flight method");
		String Message = flightService.createFlight(newFlight);
		 return Message;//Day values are not being saved as the correct input!?
		 				//Postman requests save but as wrong value?
		 				//No code changes since previous tests how is this possible?
		 				//Day value of created flight is always one less than the entered day.
	}
	@GetMapping(value = "/findAllFlights",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Flight> findAllFlights() {
		return flightService.findAllFlights();
	}
	@GetMapping (value = "/findFlight/{flightid}",produces = MediaType.APPLICATION_JSON_VALUE)//404????
	public Optional<Flight> findFlight(
			@PathVariable int flightid) { 
		return flightService.findFlight(flightid);
	}
	@GetMapping (value = "/findFlightByBooking/{bookingid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Flight> findFlightByBooking(
			@PathVariable int bookingid){
		return flightService.findFlightByBooking(bookingid);
	}
	@GetMapping (value = "/searchFlightsByPlan/{destination}/{origin}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Flight> searchFlightsByOriginAndDestination(
			@PathVariable String destination,
			@PathVariable String origin) {
		return flightService.searchFlightsByOriginAndDestination(destination, origin);
	}
	@GetMapping (value = "/searchFlightsByPlanAndDepartureDate/{origin}/{destination}/{departure}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Flight> searchFlightsByOriginAndDestinationAndDepartureDate(
			@PathVariable String origin,
			@PathVariable String destination,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date departure){
		return flightService.searchFlightsByOriginAndDestinationAndDepartureDate(origin, destination, departure);//This returns the appropriate list.
	}//These two methods basically have the same methods and SQL but this one works and the later does not.
	@GetMapping (value = "/searchFlightsByPlanAndArrivalDate/{origin}/{destination}/{arrival}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Flight> searchFlightsByOriginAndDestinationAndArrivalDate(
			@PathVariable String origin,
			@PathVariable String destination,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date arrival){
		return flightService.searchFlightsByOriginAndDestinationAndArrivalDate(origin, destination, arrival);//This returns an empty list.
	}//SQL tested from command line and returns the appropriate list
	@GetMapping (value = "/findBookingsOnFlight/{flightid}",produces = MediaType.APPLICATION_JSON_VALUE)					
	public List<FlightBooking> findBookingsOnFlight(
			@PathVariable int flightid) {	
		return flightService.findBookingsOnFlightById(flightid);
	}
	@DeleteMapping (value = "/deleteFlight" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteFlight(int flightid) {
		String deleteMessage = flightService.deleteFlight(flightid);
		return deleteMessage;
		//Postman Error???
		//"Optional int parameter 'flightid' is present but cannot be translated into a 
		//null value due to being declared as a primitive type. Consider declaring it as object wrapper for the corresponding primitive type."
	}
}
