package com.controller;
import com.service.RideService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Ride;
@RestController
public class RideController {
	


	 //view must be in this micro service project with controller as opposed to rest controller
	
		@Autowired
		RideService rideService;
		
		@GetMapping(value = "/")
		
		
		
		@PostMapping(value = "/bookRide")
		public String bookRide(Model mm, Ride r) {
			
			 System.out.println("Ride booked");
			 rideService.bookRide(r);
			 mm.addAttribute("msg1", "Thank you " );
			 mm.addAttribute("msg2", "Your ride has been booked and the Fare will be ");
			return "ride-booking";
		}
		

}
