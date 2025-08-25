package com.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bean.Flight;
import com.bean.FlightBooking;
import com.bean.User;
import com.repository.UserRepository;
@Service
public class UserService {
@Autowired
UserRepository userRepository;
@Autowired
RestTemplate restTemplate;

	public String createNewUser(User user) {
		userRepository.save(user);
		System.out.println("Create New User calling repository");
		return "You successfully created a new user";
	}
	public List<User> findAllUsers() {
		List<User> users = userRepository.findAll();
		return users;
		}
	public Optional<Long> verifyUser(String password, String email) { //New method to facilitate login 
		Optional<Long> userid = userRepository.verifyUser(password, email);//checking password and email against userid
		return userid; 
	}
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
