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
import org.springframework.web.bind.annotation.RestController;

import com.bean.Flight;
import com.bean.FlightBooking;
import com.bean.User;
import com.service.UserService;
@CrossOrigin
@RestController
public class UserController {
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
	public List<User> findUsersOnFlight(Flight flight){
	return userService.findUsersOnFlight(flight);
	}
	//New method
	@GetMapping(value = "findUserDepartureDates", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Date> findUserDepartureDates(User user){
		return userService.findUserDepartureDates(user);
	}
	//New Method
	@GetMapping(value = "findUserArrivalDates", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Date> findUserArrivalDates(User user){
		return userService.findUserArrivalDates(user);
	}
	@DeleteMapping(value = "deleteUser",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deleteUser(User user) {
	String deleteMessage = userService.deleteUser(user);
	return deleteMessage;
	}
}