package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Flight;
import com.service.FlightService;
@CrossOrigin
@RestController
public class FlightController {
	@Autowired FlightService flightService;
	@PostMapping(value = "createFlight",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createFlight(@RequestBody Flight cF) {
		
		 System.out.println("Call book flight method");
		String Message = flightService.createFlight(cF);
		 return Message;
	}
}
