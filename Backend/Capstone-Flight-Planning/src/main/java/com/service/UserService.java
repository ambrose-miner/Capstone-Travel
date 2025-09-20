package com.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bean.Flight;
import com.bean.FlightBooking;
import com.bean.Login;
//import com.bean.Login;
import com.bean.User;
import com.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
@Service
public class UserService {
@Autowired
UserRepository userRepository;
@Autowired
RestTemplate restTemplate;
@Autowired
private HttpSession session;


	public String createNewUser(User user) {
			userRepository.save(user);
			System.out.println("Create New User calling repository");
		return "You successfully created a new user";
	}
	public List<User> findAllUsers() {
			List<User> users = userRepository.findAll();
		return users;
		}
	//****New Method***
	public String verifyUser(String password, String email) { 
		Optional<Login> userLogin = userRepository.verifyUser(password, email);
			if (userLogin.isPresent()){
				String url = "http://localhost:8282/Capstone-Flight-Planning/userCurrent";
				User userCurrent = restTemplate.postForObject(url, userLogin, User.class);
				String X = ""+userCurrent.getUserid();
				storeDataInSession(userCurrent);
				//*****This is a first attempt to put user in to the session
				return "1"+ X;//Successful Login
			}else {
				return "-1";//Failed Login
			}
	}	
	public void storeDataInSession(User user) {session.setAttribute("user", user);
	}public User retrieveDataFromSession() {return (User) session.getAttribute("user");
	}
	
//	 ****Reference Code*****
//	public String signIn(Login login){ 
//		String url1 = "http://localhost:8282/user/userVerification/{password}/{email}";
//		
//		User verifyingUser = restTemplate.postForObject(url1, login, User.class);
//		
//		Optional<User> optionalVerifyingUser = Optional.ofNullable(verifyingUser);
	//String url = "http://localhost:8181/Capstone-login/login";
	//Optional<User> userLogin = restTemplate.postForObject(url, userLogin, User.class);
	//User userLoggedIn = Optional.ofNullable(userLogin)
	//return userLogin1;
		
	public List<User> findUsersOnFlight(int flightid){
		List<User> passengers = userRepository.findUsersOnFlight(flightid);
		return passengers;
	}
	public List<Date> findUserDepartureDates(Long userid){
		List<Date> departures = userRepository.findUserDepartureDates(userid);
		return departures;
	}
	public List<Date> findUserArrivalDates(Long userid){
		List<Date> arrivals = userRepository.findUserArrivalDates(userid);
		return arrivals;
	}
	public String deleteUser(Long userid) {
		userRepository.deleteById(userid);
		return "User deleted";
	}
}
