package com.service;

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
	public String deleteUser(User user) {
		userRepository.delete(user);
		return "User deleted";
	}
}
