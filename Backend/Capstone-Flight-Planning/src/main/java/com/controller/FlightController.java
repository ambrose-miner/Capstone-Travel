package com.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
		 return Message;
	}
	@GetMapping(value = "/findAllFlights",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Flight> findAllFlights() {
		return flightService.findAllFlights();
	}
	@GetMapping (value = "/findFlight",produces = MediaType.APPLICATION_JSON_VALUE)//404????
	public Optional<Flight> findFlight(
			@PathVariable int flightid) { 
		return flightService.findFlight(flightid);
	}
	@GetMapping (value = "/findFlightByBooking {bookingid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Flight> findFlightByBooking(
			@PathVariable int bookingid){
		return flightService.findFlightByBooking(bookingid);
	}
	@GetMapping (value = "/searchFlightsByPlan {destination},{origin}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Flight> searchFlightsByOriginAndDestination(
			@PathVariable String destination,
			@PathVariable String origin) {
		return flightService.searchFlightsByOriginAndDestination(destination, origin);
	}
	@GetMapping (value = "/searchFlightsByPlanAndDepartureDate {origin},{destination},{departure}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Flight> searchFlightsByOriginAndDestinationAndDepartureDate(//404 No static resource flight/searchFlightsByPlanAndArrivalDate.",
			@PathVariable String origin,
			@PathVariable String destination,
			@PathVariable Date departure){
		return flightService.searchFlightsByOriginAndDestinationAndDepartureDate(origin, destination, departure);
	}
	@GetMapping (value = "/searchFlightsByPlanAndArrivalDate {origin},{destination},{arrival}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Flight> searchFlightsByOriginAndDestinationAndArrivalDate(//Returns Error 404 No static resource flight/searchFlightsByPlanAndArrivalDate.",
			@PathVariable String origin,
			@PathVariable String destination,
			@PathVariable Date arrival){
		return flightService.searchFlightsByOriginAndDestinationAndArrivalDate(origin, destination, arrival);
	}
	@GetMapping (value = "/findBookingsOnFlight {flightid}",produces = MediaType.APPLICATION_JSON_VALUE)//404 not found					
	public List<FlightBooking> findBookingsOnFlight(
			@PathVariable int flightid) {	
		return flightService.findBookingsOnFlightById(flightid);
	}
	@DeleteMapping (value = "/deleteFlight" ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deleteFlight(int flightid) {
		String deleteMessage = flightService.deleteFlight(flightid);
		return deleteMessage;
	}
}
