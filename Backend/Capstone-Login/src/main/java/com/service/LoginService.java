package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bean.User;
import com.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	@Autowired
	RestTemplate restTemplate;
	
	public User
	sendUserInfo(User user){
		String url = "http://localhost:8282/Capstone-Flight-Planning";
		User currentUser = restTemplate.postForObject(url, user, User.class);// does this need to be embedded in a way inside the sign in
		return currentUser;										//method so that it is only trying to send the User object after it has it?
	}
	public String signIn(User user) {		
		Optional<User> result = loginRepository.findById(user.getUserid());//This will no longer match up with the front end. User vs Login
		if(result.isPresent()) {											
							
			User ll = result.get();			// ll hold email, password and typeofuser from db.
												// will be taking email and password and getting userid and typeofuser from db.
					if(ll.getPassword().equals(user.getPassword())) {
						
							if(ll.getUsertype().equals(user.getUsertype()) && user.getUsertype().equals("admin")) {
								return "Admin login";
							}else if(ll.getUsertype().equals(user.getUsertype()) && user.getUsertype().equals("customer")) {
								return "You have loged in successfully";
							}else {
								return "You can not log in as Admin";
							}
						
					}else {
						return "Wrong email or password P";
					}
		}else {
			
			return "Wrong email or password E";
		}
	}
	//New attempt at cleaning up and combining above methods no need for checking user type here.
	//will need to return user or admin page on the front end currentUser object will have that in it.
	
//	public String signIn(User user) {					
//		Optional<User> varifyingUser = loginRepository.findById(user.getUserid());
//		User currentUser = varifyingUser.get();
//		if(varifyingUser.isPresent()) {
//			String url = "http://localhost:8282/Capstone-Flight-Planning";
//			User currentUser = restTemplate.postForObject(url, user, User.class);
//				if(currentUser.getPassword().equals(user.getPassword()) && currentUser.getEmail().equals(user.getEmail()) {
//					if(currentUser.getUsertype().equals("admin");
//						return "admin home link";
//					if{(currentUser.getUsertype().equals("customer");
//						return "customer home link";
	
//				}else {
//					return "Wrong email or password";	
//	}
	
	public String signUp(User user) { 
		Optional<User> result = loginRepository.findById(user.getUserid());
		if(result.isPresent()) {
				return "That account already exists";
		}else {
			//if(user.getUsertype().equals("admin")) {
				//return "You can't create admin account";
			//}else {
			loginRepository.save(user);
			return "Account created successfully";
			}
		}
	}