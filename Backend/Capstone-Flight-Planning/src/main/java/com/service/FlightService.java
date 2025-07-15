package com.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import com.repository.FlightRepository;
import com.bean.Flight;
import com.bean.FlightBooking;
import com.bean.User;

public class FlightService {
	@Autowired
	FlightRepository flightRepository;
	@Autowired
	RestTemplate restTemplate;
	

	public String createFlight(Flight cF) {
			flightRepository.save(cF);
			System.out.println("Create flight calling repository");
			return "Your flight has been created successfully";
		}
	public List<Flight> findAllFlights() {
		List<Flight> Flights = flightRepository.findAll();
		return Flights;
	}
	public List<Flight> findFlight(FlightBooking flightBooking) { 
		List<Flight> flightBooked = flightRepository.findByFlightBooking(flightBooking);
		return flightBooked;
	}
	public List<Flight> searchFlightsByOriginAndDestination(Flight origin, Flight destination) {
		List<Flight> flightPlan = flightRepository.searchFlightsByOriginAndDestination(origin, destination);
		return flightPlan;
	}
	public List<Flight> searchFlightsByDepartureDateAndOriginAndDestination(Flight origin, Flight destination, Flight departure){
		List<Flight> flightDeparturePlan = flightRepository.searchFlightsByDepartureDateAndOriginAndDestination(origin, destination, departure);
		return flightDeparturePlan;
	}
	public List<Flight> searchFlightsByDepartureDateAndOriginAndArrival(Flight origin, Flight destination, Flight arrival){
		List<Flight> flightArrivalPlan = flightRepository.searchFlightsByDepartureDateAndOriginAndArrival(origin, destination, arrival);
		return flightArrivalPlan;
	}
}
