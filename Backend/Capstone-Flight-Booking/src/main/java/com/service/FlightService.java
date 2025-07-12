package com.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bean.FlightBooking;
import com.repository.FlightRepository;

@Service
public class FlightService { //should now be flightBookingService...?
	@Autowired
	FlightRepository flightRepository; //would change to flightBookingRepository...?
	@Autowired
	RestTemplate restTemplate;
	
	public String bookFlight(FlightBooking fB) {
		float amount = restTemplate.getForObject("http://localhost:8282/fare/findFare/"+fB.getOrigin()+"/"+fB.getDestination(), Float.class);
		if(amount==-1) {// should be price not fare if price is user specific this would have to look at the user object
			//that doesn't seem right... maybe I shouldn't make the price user specific. can always call it a base price
			//and have modifiers for users.
			return "No Flights are avaiable with origin location as "+fB.getOrigin()+" and destination as "+fB.getDestination();
		}else {
			fB.setPrice(amount); 
			flightRepository.save(fB);
			System.out.println("book flight calling repository");
			return "Your flight has been booked successfully";
		}
	}
}