package com.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.FlightBooking;
import com.bean.User;
import com.service.UserService;

public class UserController {

	@GetMapping(value = "findAllUsers",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAllUsers() {
		try {
			return UserService.findAllUsers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // has issue with UserService.findAllUsers(); says...
	}								//Cannot make a static reference to the non-static method findAllUsers() from the type UserService
}
