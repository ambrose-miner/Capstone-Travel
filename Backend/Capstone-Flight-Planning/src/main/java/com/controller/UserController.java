package com.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bean.Flight;
import com.bean.FlightBooking;
import com.bean.User;
import com.service.UserService;
@CrossOrigin

public class UserController {
@Autowired
RestTemplate restTemplate;
@Autowired
UserService userService;
	@PostMapping(value = "createNewUser",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createNewUser(@RequestBody User user) {	
		System.out.println("Call create user method");
		String Message = userService.createNewUser(user);
		return Message;
	}
	@GetMapping(value = "findAllUsers",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAllUsers() {
			return userService.findAllUsers();	
	}
	
	@GetMapping(value = "findUsersOnFlight",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findUsersOnFlight(@RequestParam int flightid){
	return userService.findUsersOnFlight(flightid);
	}
	
	@GetMapping(value = "findUserDepartureDates", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Date> findUserDepartureDates(@RequestParam Long userid){
		String url = "http://localhost:8181/Capstone-Login/login/"+ userid;
		restTemplate.getForObject(url, User.class);
		return userService.findUserDepartureDates(userid);
	}
	
	@GetMapping(value = "findUserArrivalDates", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Date> findUserArrivalDates(@RequestParam Long userid){
		String url = "http://localhost:8181/Capstone-Login/login/"+ userid;
		restTemplate.getForObject(url, User.class);
		return userService.findUserArrivalDates(userid);
	}
	//User delete account/ unsign-up
	@DeleteMapping(value = "deleteUser",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deleteUserById(@RequestParam Long userid) {
		String url = "http://localhost:8181/Capstone-Login/login/"+ userid;
		restTemplate.getForObject(url, User.class);
		String deleteMessage = userService.deleteUser(userid);
		return deleteMessage;
	}
}