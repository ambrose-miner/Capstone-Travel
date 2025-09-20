package com.controller;
import com.service.FlightBookingService;
import com.service.FlightService;

import jakarta.ws.rs.PathParam;

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
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping(value = "/bookFlight",consumes = MediaType.APPLICATION_JSON_VALUE)//This works but does not have user attached
	public String bookFlight(
			@RequestBody FlightBooking flightBooking,
			@RequestParam("userid") Long userid)
			 {	
		System.out.println("Call book flight method");
		String url = "http://localhost:8181/Capstone-Login/login/";
		Long X = restTemplate.getForObject(url, Long.class);
		String Message = flightBookingService.bookFlight(flightBooking, userid);
		 return Message + X;														
	}//getting userid from rest template need to attach to flight booking
	//userid is error on ln46 "Duplicate local variable userid"
	//this doesnt get user id from login either...
	@GetMapping(value = "/findAllFlightBooking",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findAllFlightBooking() {
		return flightBookingService.findAllFlightBooking();
	}
	
	@GetMapping (value = "/findUserFlightBooking/{userid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findUserFlightBooking(
			@PathVariable("userid") Long userid) {//works but returns empty....
		//String url = "http://localhost:8181/Capstone-Login/login/"+ userid;
		//restTemplate.getForObject(url, User.class);						
		return flightBookingService.findUserFlightBooking(userid);
	}
	
	@GetMapping (value = "/findUserFlightBookingAdmin/{userid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findUserFlightBookingAdmin(
			@PathVariable("userid") Long userid) {
		String url = "http://localhost:8181/Capstone-Login/login/"+ userid;//this is not getting the userid from login
		restTemplate.getForObject(url, User.class);
		return flightBookingService.findUserFlightBooking(userid);
	}
	
	@GetMapping (value = "/findUserFlightBookingByArrivalDate/{userid}/{arrival}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findUserFlightBookingByArrivalDate(
			@PathVariable (value = "userid", required = true) Long userid, 
			@PathVariable (value = "arrival", required = false) Date arrival){ 
				String url = "http://localhost:8181/Capstone-Login/login/" + userid;
				restTemplate.getForObject(url, User.class);
			return flightBookingService.findUserFlightBookingByArrivalDate(userid, arrival);
	}

	@GetMapping (value = "/findUserFlightBookingByDepartureDate/{userid}/{departure}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findUserFlightBookingByTravalDate(
			@PathVariable (value = "userid", required = true) Long userid,
			@PathVariable (value = "departure", required = false) Date departure){
				String url = "http://localhost:8181/Capstone-Login/login/" + userid;
				restTemplate.getForObject(url, User.class);
			return flightBookingService.findUserFlightBookingByDepartureDate(userid, departure);
	}
	
	@DeleteMapping(value = "/deleteFlightBooking",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deleteFlightBooking(FlightBooking flightBooking) { 
		String deleteMessage = flightBookingService.deleteFlightBooking(flightBooking);
		return deleteMessage;
	}
	
	

}
