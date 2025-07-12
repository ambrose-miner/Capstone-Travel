package com.controller;
import com.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Ride;
@CrossOrigin
@RestController
public class RideController {
	
		@Autowired
		RideService rideService;
		
		@GetMapping(value = "/")// needs to be more specific...?
		
		
		@PostMapping(value = "bookRide", consumes = MediaType.APPLICATION_JSON_VALUE)
		public String bookRide(@RequestBody Ride r) { //ridebooking?
			 System.out.println("called booking ride method");
			 String Message = rideService.bookRide(r);
			return Message;
		}
		

}
