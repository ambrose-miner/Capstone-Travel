package com.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.bean.Flight;
import com.bean.FlightBooking;
import com.bean.Login;
import com.bean.User;
import com.service.UserService;

import jakarta.servlet.http.HttpSession;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
@Autowired
private HttpSession session;
@Autowired					
RestTemplate restTemplate;
@Autowired
UserService userService;
		
	//http://localhost:8282/user/createNewUser
	@PostMapping(value = "/createNewUser",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createNewUser(@RequestBody User user) {	
				System.out.println("Call create user method");
				String Message = userService.createNewUser(user);
			return Message;
	} 
	//http://localhost:8282/user/findAllUsers
	@GetMapping(value = "/findAllUsers",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAllUsers() {
			return userService.findAllUsers();	
	}
	//http://localhost:8282/user/{password}/{email}
	@PostMapping(value = "/userVerification",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getUserVerification
				(@RequestBody Login login){
				String password = login.getPassword();
				String email = login.getEmail();	
			return userService.verifyUser(password, email);
	}
	//Test get session value code hmmm... returns
	//Cannot invoke \"com.bean.User.getUserid()\" because \"userCurrent\" is null",
	@GetMapping(value = "/Test",produces = MediaType.APPLICATION_JSON_VALUE)
	public Long getObject() {
		String attributeValue = (String) session.getAttribute("Test Atribute");
//		User myUser = new User();
//		myUser.setUserid(1234567L);
//		session.setAttribute("userCurrent", myUser);
		System.out.println("************* sessionid from Controller =" +session.getId());
		User userCurrent = (User) session.getAttribute("userCurrent");
		Long userid = userCurrent.getUserid();
		return userid;
	}
	@GetMapping(value = "/findUsersOnFlight",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findUsersOnFlight(@RequestParam int flightid){//Admin
			return userService.findUsersOnFlight(flightid);
	}
	
	@GetMapping(value = "/findUserDepartureDates", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Date> findUserDepartureDates(@RequestParam Long userid){
		User userCurrent = (User) session.getAttribute("userCurrent");
		userid = userCurrent.getUserid();
			return userService.findUserDepartureDates(userid);
	}
	
	@GetMapping(value = "/findUserArrivalDates", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Date> findUserArrivalDates(@RequestParam Long userid){
		User userCurrent = (User) session.getAttribute("userCurrent");
		userid = userCurrent.getUserid();
			return userService.findUserArrivalDates(userid);
	}
	
	@DeleteMapping(value = "/deleteUser")
	public String userDeleteUserById(@PathVariable Long userid) {		//user delete user
		User userCurrent = (User) session.getAttribute("userCurrent");
		userid = userCurrent.getUserid();
				String deleteMessage = userService.deleteUser(userid);
			return deleteMessage;
	}//These two delete methods call the same method in user service and just have different in puts for the userid.
	@DeleteMapping(value = "/deleteUser/{userid}")//Admin delete user
	public String adminDeleteUserById(@PathVariable Long userid) {
				String deleteMessage = userService.deleteUser(userid);
			return deleteMessage;
	}
}