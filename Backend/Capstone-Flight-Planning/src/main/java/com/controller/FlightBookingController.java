package com.controller;
import com.service.FlightBookingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bean.User;
import com.bean.Flight;
import com.bean.FlightBooking;
@CrossOrigin
@RestController
public class FlightBookingController {
	@Autowired
	FlightBookingService flightBookingService;
	
	@GetMapping(value = "findAllFlightBooking",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findAllFlightBooking() {
		return flightBookingService.findAllFlightBooking();
	}
	@GetMapping (value = "findUserFlightBooking",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findUserFlightBooking(User user) { //passing user object to find user's flightBookings.
		return flightBookingService.findUserFlightBooking(user);
	}
	//@GetMapping(value = "find",produces = MediaType.APPLICATION_JSON_VALUE)
	//public List<Product> findAllProducts() {
	//	return productService.findAllProducts();
	//}
	//@PostMapping(value = "store",consumes = MediaType.APPLICATION_JSON_VALUE) //example of post method not for Thymeleaf 
	//public String storeProduct(@RequestBody Product product) {
	//	return productService.storeProduct(product);
	//}
	@DeleteMapping(value = "deleteFlightBooking",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteFlightBooking(FlightBooking flightBooking) { 
		flightBookingService.deleteFlightBooking(flightBooking);
	}
	
	@PostMapping(value = "bookFlight",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String bookFlight(@RequestBody FlightBooking fB) {
		
		 System.out.println("Call book flight method");
		String Message = flightBookingService.bookFlight(fB);
		 return Message;
	}


}
