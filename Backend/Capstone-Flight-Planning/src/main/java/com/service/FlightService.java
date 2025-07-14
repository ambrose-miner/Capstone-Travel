package com.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import FlightRepository;//why is this not recognizing FlightRepository?????
import com.bean.Flight;
import com.bean.FlightBooking;

public class FlightService {
	@Autowired
	FlightRepository flightRepository; //why is this not recognizing FlightRepository?????
	@Autowired
	RestTemplate restTemplate;
	

	public String createFlight(Flight cF) {
			cF.setPrice(price, cF); 
			cF.setOrigin(origin, cF);
			cF.setDestination(destination, cF);
			cF.setArrival(arrival, cF);
			cF.setDeparture(departure, cF);
			cF.setAirline(airline, cF);
			flightRepository.save(cF);
			System.out.println("Create flight calling repository");
			return "Your flight has been created successfully";
		}
	public List<Flight> findAllFlights() {
		List<FlightBooking> bookedFlights = flightRepository.findAll();//still can't recognize flightRepository...? could this trace back 
																		// to the issues with the bean class..? that doesn't seem right.
																		//What am I missing????
		return findAllFlights();
	}
}
