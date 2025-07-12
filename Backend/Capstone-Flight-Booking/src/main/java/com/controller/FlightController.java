package com.controller;
import com.service.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.FlightBooking;
@CrossOrigin
@RestController
public class FlightController {
	@Autowired
	FlightService flightService;
	
	@GetMapping(value = "/")
	
	//@PostMapping(value = "store",consumes = MediaType.APPLICATION_JSON_VALUE) //example of post method not for Thymeleaf 
	//public String storeProduct(@RequestBody Product product) {
	//	return productService.storeProduct(product);
	//}
	
	@PostMapping(value = "bookFlight",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String bookFlight(@RequestBody FlightBooking fB) {
		
		 System.out.println("Call book flight method");
		String Message = flightService.bookFlight(fB);
		 return Message;
	}


}
