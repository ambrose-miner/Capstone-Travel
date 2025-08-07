package com.service;

import java.sql.Date;
import java.util.List;

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

	public List<User> findAllUsers() {
		List<User> users = userRepository.findAll();
		return users;
		}
	public List<User> findUsersOnFlight(Flight flight){
		List<User> passengers = userRepository.findUsersOnFlight(flight);
		return passengers;
	}
	public String createNewUser(User user) {
		userRepository.save(user);
		System.out.println("Create New User calling repository");
		return "You successfully created a new user";
	}
	public List<Date> findUserDepartureDates(User user){
		List<Date> departures = userRepository.findUserDepartureDates(user);
		return departures;
	}
	public List<Date> findUserArrivalDates(User user){
		List<Date> arrivals = userRepository.findUserArrivalDates(user);
		return arrivals;
	}
	public String deleteUser(User user) {
		userRepository.delete(user);
		return "User deleted";
	}
}
