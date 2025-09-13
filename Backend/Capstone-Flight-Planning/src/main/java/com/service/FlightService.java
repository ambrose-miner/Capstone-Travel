package com.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.repository.FlightRepository;
import com.bean.Flight;
import com.bean.FlightBooking;
import com.bean.User;
@Service
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
	public List<Flight> searchFlightsByOriginAndDestination(String destination, String origin) {
		List<Flight> flightPlan = flightRepository.findFlightsByOriginAndDestination(
				destination,
				origin
				);
		return flightPlan;
	}
	public List<Flight> searchFlightsByOriginAndDestinationAndDepartureDate(String origin, String destination, Date departure){
		List<Flight> flightDeparturePlan = flightRepository.findFlightsByOriginAndDestinationAndDepartureDate(
				origin,
				destination,
				departure
				);
		return flightDeparturePlan;
	}
	public List<Flight> searchFlightsByOriginAndDestinationAndArrivalDate(String origin, String destination, Date arrival){
		List<Flight> flightArrivalPlan = flightRepository.findFlightsByOriginAndDestinationAndArrivalDate(
				origin,
				destination,
				arrival
				);
		return flightArrivalPlan;
	}
	public String deleteFlight(int flightid) {
		flightRepository.deleteById(flightid);
		return "flight deleted";
	}
}
