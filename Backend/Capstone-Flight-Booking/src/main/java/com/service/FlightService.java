package com.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bean.FlightBooking;
import com.repository.FlightRepository;

@Service
public class FlightService {
	@Autowired
	FlightRepository flightRepository;
	@Autowired
	RestTemplate restTemplate;
	
	public String bookFlight(FlightBooking rI) {
		float amount = restTemplate.getForObject("http://localhost:8282/fare/findFare/"+rI.getOrigin()+"/"+rI.getDestination(), Float.class);
		if(amount==-1) {
			return "No Flights are avaiable with origin location as "+rI.getOrigin()+" and destination as "+rI.getDestination();
		}else {
			rI.setPrice(amount); 
			flightRepository.save(rI);
			return "Your flight has been booked successfully";
		}
	}
}