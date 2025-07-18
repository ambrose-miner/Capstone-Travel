package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Flight;
import com.bean.FlightBooking;
import com.bean.User;
import com.service.FlightService;
@CrossOrigin
@RestController

public class FlightController {
	
	@Autowired FlightService flightService;
	
	@PostMapping(value = "createFlight",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createFlight(@RequestBody Flight newFlight) {
		 System.out.println("Call book flight method");
		String Message = flightService.createFlight(newFlight);
		 return Message;
	}
	@GetMapping(value = "findAllFlights",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Flight> findAllFlights() {
		return flightService.findAllFlights();
	}
	@GetMapping (value = "findFlight",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Flight> findFlight(@RequestParam FlightBooking flightBooking) { 
		return flightService.findFlight(flightBooking);
	}
	@GetMapping (value = "searchFlightsByPlan",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Flight> searchFlightsByOriginAndDestination(@RequestParam Flight origin, Flight destination) {
		return flightService.searchFlightsByOriginAndDestination(origin, destination);
	}
	@GetMapping (value = "searchFlightsByPlanAndDepartureDate",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Flight> searchFlightsByOriginAndDestinationAndDepartureDate(@RequestParam Flight origin, Flight destination, Flight departure) {
		return flightService.searchFlightsByOriginAndDestinationAndDepartureDate(origin, destination, departure);
	}
	@GetMapping (value = "searchFlightsByPlanAndArrivalDate",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Flight> searchFlightsByOriginAndDestinationAndArrivalDate(@RequestParam Flight origin, Flight destination, Flight arrival) {
		return flightService.searchFlightsByOriginAndDestinationAndArrivalDate(origin, destination, arrival);
	}
}
