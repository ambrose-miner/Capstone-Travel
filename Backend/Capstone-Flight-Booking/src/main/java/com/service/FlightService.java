package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import FlightRepository;//why is this not recognizing FlightRepository?????
import com.bean.Flight;

public class FlightService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	FlightRepository flightRepository; //why is this not recognizing FlightRepository?????
}
	public String createFlight(Flight cF) {
			cF.setPrice(price, cF); 
			flightRepository.save(cF);
			System.out.println("Create flight calling repository");
			return "Your flight has been created successfully";
		}
}
