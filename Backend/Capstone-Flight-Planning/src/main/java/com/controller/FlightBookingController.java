package com.controller;
import com.service.FlightBookingService;
import com.service.FlightService;

import jakarta.servlet.http.HttpSession;
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
	@Autowired
	private HttpSession session;
	
	@PostMapping(value = "/bookFlight",consumes = MediaType.APPLICATION_JSON_VALUE)//This works but does not have user attached
	public String bookFlight(
			@RequestParam("flightid") int flightid,
			@RequestParam("userid") Long userid)
			 {	
		System.out.println("Call book flight method");
		User userCurrent = (User) session.getAttribute("userCurrent");
		userid = userCurrent.getUserid();	
		String Message = flightBookingService.bookFlight(flightid, userid);
		 return Message;// + X;	//													
	}
	@GetMapping(value = "/findAllFlightBooking",produces = MediaType.APPLICATION_JSON_VALUE)//Admin
	public List<FlightBooking> findAllFlightBooking() {
		return flightBookingService.findAllFlightBooking();
	}
	
	@GetMapping (value = "/findUserFlightBooking",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findUserFlightBooking(
			@PathVariable("userid") Long userid) {
				User userCurrent = (User) session.getAttribute("userCurrent");
				userid = userCurrent.getUserid();			
		return flightBookingService.findUserFlightBooking(userid);
	}
	
	@GetMapping (value = "/findUserFlightBookingAdmin/{userid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findUserFlightBookingAdmin(
			@PathVariable("userid") Long userid) {
		//this does not get the userid from login
		//gets user ID from Admin input
		//Returns error that the userCurrent is null in the session...?? This method doesn't use the session.
		//<Error Return in Postman> Cannot invoke \"com.bean.User.getUserid()\" because \"userCurrent\" is null 
		return flightBookingService.findUserFlightBooking(userid);
	}
	
	@GetMapping (value = "/findUserFlightBookingByArrivalDate/{arrival}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findUserFlightBookingByArrivalDate(
			@PathVariable (value = "userid", required = true) Long userid, 
			@PathVariable (value = "arrival", required = false) Date arrival){ 
				User userCurrent = (User) session.getAttribute("userCurrent");
				userid = userCurrent.getUserid();
			return flightBookingService.findUserFlightBookingByArrivalDate(userid, arrival);
	}

	@GetMapping (value = "/findUserFlightBookingByDepartureDate/{departure}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightBooking> findUserFlightBookingByTravalDate(
			@PathVariable (value = "userid", required = true) Long userid,
			@PathVariable (value = "departure", required = false) Date departure){
				User userCurrent = (User) session.getAttribute("userCurrent");
				userid = userCurrent.getUserid();
			return flightBookingService.findUserFlightBookingByDepartureDate(userid, departure);
	}
	
	@DeleteMapping(value = "/deleteFlightBooking",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deleteFlightBooking(FlightBooking flightBooking) { 
		String deleteMessage = flightBookingService.deleteFlightBooking(flightBooking);
		return deleteMessage;
	}
	
	

}
