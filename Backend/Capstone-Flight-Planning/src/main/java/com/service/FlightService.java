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
	

	public String createFlight(Flight newFlight) {
			flightRepository.save(newFlight);
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
	public List<Flight> searchFlightsByOriginAndDestination(Flight flight) {
		List<Flight> flightPlan = flightRepository.searchFlightsByOriginAndDestination(flight.getOrigin(), flight.getDestination());
		return flightPlan;
	}
	public List<Flight> searchFlightsByOriginAndDestinationAndDepartureDate(Flight flight){
		List<Flight> flightDeparturePlan = flightRepository.searchFlightsByOriginAndDestinationAndByDepartureDate(flight.getOrigin(), flight.getDestination(), flight.getDeparture());
		return flightDeparturePlan;
	}
	public List<Flight> searchFlightsByOriginAndDestinationAndArrivalDate(Flight flight){
		List<Flight> flightArrivalPlan = flightRepository.searchFlightsByOriginAndDestinationAndArrivalDate(flight.getOrigin(), flight.getDestination(), flight.getArrival());
		return flightArrivalPlan;
	}
}
