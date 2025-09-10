package com.controller;
import com.service.FlightBookingService;
import com.service.FlightService;



import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
//import jakarta.persistence.Id;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bean.User;
import com.bean.Flight;
import com.bean.FlightBooking;
@CrossOrigin
@RestController
@RequestMapping("/flightBooking")
public class FlightBookingController {
	
	@Autowired
	FlightBookingService flightBookingService;
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping(value = "/bookFlight",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String bookFlight(@RequestBody FlightBooking flightBooking) {	
		System.out.println("Call book flight method");
		String Message = flightBookingService.bookFlight(flightBooking);
		 return Message;
	}
	
	@GetMapping(value = "/findAllFlightBooking",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findAllFlightBooking() {
		return flightBookingService.findAllFlightBooking();
	}
	
	@GetMapping (value = "/findUserFlightBooking",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findUserFlightBooking(@RequestParam Long userid) {
		//String url = "http://localhost:8181/Capstone-Login/signIn/"+ userid; //login service @RequestMapping("/login") change?
		String url = "http://localhost:8181/Capstone-Login/login/"+ userid;
		restTemplate.getForObject(url, User.class);						
		return flightBookingService.findUserFlightBooking(userid);
	}
	
	@GetMapping (value = "/findUserFlightBookingAdmin",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findUserFlightBookingAdmin(@RequestParam Long userid) {
		String url = "http://localhost:8181/Capstone-Login/login/"+ userid;//This line not needed/different Url.
		restTemplate.getForObject(url, User.class);
		return flightBookingService.findUserFlightBooking(userid);
	}
	
	@GetMapping (value = "/findUserFlightBookingByArrivalDate",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findUserFlightBookingByArrivalDate(
			@RequestParam (value = "userid", required = true) Long userid, 
			@RequestParam (value = "arrival", required = false) Date arrival){ 
				String url = "http://localhost:8181/Capstone-Login/login/" + userid;
				restTemplate.getForObject(url, User.class);
			return flightBookingService.findUserFlightBookingByArrivalDate(userid, arrival);
	}

	@GetMapping (value = "/findUserFlightBookingByDepartureDate",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findUserFlightBookingByTravalDate(
			@RequestParam (value = "userid", required = true) Long userid,
			@RequestParam (value = "departure", required = false) Date departure){
				String url = "http://localhost:8181/Capstone-Login/login/" + userid;
				restTemplate.getForObject(url, User.class);
			return flightBookingService.findUserFlightBookingByDepartureDate(userid, departure);
	}
	
	@GetMapping (value = "/findBookingsOnFlight",produces = MediaType.APPLICATION_JSON_VALUE)					
	public List<FlightBooking> findBookingsOnFlight(@RequestParam int flightid) {	
		return flightBookingService.findBookingsOnFlightById(flightid);
	}
	
	@DeleteMapping(value = "/deleteFlightBooking",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deleteFlightBooking(FlightBooking flightBooking) { 
		String deleteMessage = flightBookingService.deleteFlightBooking(flightBooking);
		return deleteMessage;
	}
	
	

}
