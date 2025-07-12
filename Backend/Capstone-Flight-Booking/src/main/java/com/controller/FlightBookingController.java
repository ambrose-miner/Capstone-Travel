package com.controller;
import com.service.FlightBookingService;

import java.util.List;

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
public class FlightBookingController {
	@Autowired
	FlightBookingService flightBookingService;
	
	@GetMapping(value = "findFlight",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Flight> findAllFlights() {
		return flightBookingService.findAllFlights();//needs limiting parameters...date time destination
	}
	//@GetMapping(value = "find",produces = MediaType.APPLICATION_JSON_VALUE)
	//public List<Product> findAllProducts() {
	//	return productService.findAllProducts();
	//}
	//@PostMapping(value = "store",consumes = MediaType.APPLICATION_JSON_VALUE) //example of post method not for Thymeleaf 
	//public String storeProduct(@RequestBody Product product) {
	//	return productService.storeProduct(product);
	//}
	
	@PostMapping(value = "bookFlight",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String bookFlight(@RequestBody FlightBooking fB) {
		
		 System.out.println("Call book flight method");
		String Message = flightBookingService.bookFlight(fB);
		 return Message;
	}


}
