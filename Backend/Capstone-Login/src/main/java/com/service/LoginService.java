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
	
	private RestTemplate restTemplate = new RestTemplate();
	//This is the only return of "new rest template" there should be only one all other uses should be putting in or pulling from
	//the already existing rest template. But is this where it should be substantiated? As private do I need setter and getter methods?
	//And if that is the case do I want to make a rest template bean class?
	
	public User
	sendUserInfo(User user){
		String url = "http://localhost:8282/Capstone-Flight-Planning";
		User createdUser = restTemplate.postForObject(url, user, User.class);// does this need to be embedded in a way inside the sign in
		return createdUser;										//method so that it is only trying to send the User object after it has it?
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
//	public String signIn(User user) {					
//		Optional<Login> validLogin = loginRepository.findById(user.getUserid());
//		if(validLogin.isPresent()) {
//			Login userLogin = validLogin.get();
//			if(userLogin.)
//		}
//		
//		
//	}
	
	public String signUp(User user) { 
		Optional<User> result = loginRepository.findById(user.getUserid());
		if(result.isPresent()) {
				return "That account already exists";
		}else {
			if(user.getUsertype().equals("admin")) {
				return "You can't create admin account";
			}else {
			loginRepository.save(user);
			return "Account created successfully";
			}
		}
	}
}