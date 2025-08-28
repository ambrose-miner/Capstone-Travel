package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bean.Login;
import com.bean.User;
//import com.bean.User;
import com.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	@Autowired
	RestTemplate restTemplate;
	
//	public Login
//	sendUserInfo(Login login){
//		String url = "http://localhost:8282/Capstone-Flight-Planning";
//		Login currentUser = restTemplate.postForObject(url, login, Login.class);// does this need to be embedded in a way inside the sign in
//		return currentUser;										//method so that it is only trying to send the User object after it has it?
//	}
//	public String signIn(Login login) {		
//		Optional<Login> result = loginRepository.findById(login.getPassword());//This will no longer match up with the front end. User vs Login
//		if(result.isPresent()) {											
//							
//			Login ll = result.get();			// ll hold email, password and typeofuser from db.
//												// will be taking email and password and getting userid and typeofuser from db.
//					if(ll.getPassword().equals(login.getPassword())) {
//						
//							if(ll.getLogintype().equals(login.getUsertype()) && login.getUsertype().equals("admin")) {
//								return "Admin login";
//							}else if(ll.getLogintype().equals(login.getUsertype()) && login.getUsertype().equals("customer")) {
//								return "You have loged in successfully";
//							}else {
//								return "You can not log in as Admin";
//							}
//						
//					}else {
//						return "Wrong email or password P";
//					}
//		}else {
//			
//			return "Wrong email or password E";
//		}
//	}
		//The below four lines removed from sign in method to simplify and stream line.
			//if(currentUser.getUsertype().equals("admin");
			//		return "admin home link";
			//	if{(currentUser.getUsertype().equals("customer");
			//		return "customer home link";
	
	//New attempt at cleaning up and combining above methods no need for checking user type here.
	//will need to return user or admin page on the front end currentUser object will have that in it.
	
//	public String signIn(User user) {			//This needs to be changed back to Login. create login class...?		
//		Optional<User> varifyingUser = loginRepository.findById(user.getUserid());
//		User currentUser = varifyingUser.get();
//		if(varifyingUser.isPresent()) {
//			String url = "http://localhost:8282/Capstone-Flight-Planning";
//			User currentUser = restTemplate.postForObject(url, user, User.class);//currentUser is flagged as duplicate local variable.
//				if(currentUser.getPassword().equals(user.getPassword()) && currentUser.getEmail().equals(user.getEmail())) {
//				}else {
//	
//						return "Wrong email or password";
//				}
//		}
//	}
	
	//Attempt to reform the above method around a login object and compairing login properties to user then get userid
	//http://localhost:8282/user/{password}/{email}
	public String signIn(Login login){
		String url1 = "http://localhost:8282/user/{password}/{email}";
		restTemplate.postForObject(url1, login, Login.class);
		String url2 = "http://localhost:8282/user";// This url needs to be double checked.
		Optional<Long> varifyingUser = restTemplate.getForObject(url2, userid, User.class);	//userid can not resolve to a variable...??
		if( varifyingUser.isPresent()) {
			//Not totally sure how to bring these elements together.
			String url3= "http://localhost:8282/Capstone-Flight-Planning";
			Login currentUser = restTemplate.postForObject(url3, login, Login.class);
			return
		}	
	//public Optional<Long> getUser(String password , String email){
		//login.getPassword(), login.getEmail())
	}

	

	public String signUp(Login login) { 
		Optional<Login> result = loginRepository.findById(login.getPassword());
		if(result.isPresent()) {
				return "That account already exists";
		}else {
			//if(user.getUsertype().equals("admin")) {
				//return "You can't create admin account";
			//}else {
			loginRepository.save(login);
			return "Account created successfully";
			}
		}
	}