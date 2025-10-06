package com.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.bean.Login;
import com.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	@Autowired 
	RestTemplate restTemplate;
	public LoginService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^Professors Code^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//	public String signIn(Login login) {		
//		Optional<Login> result = loginRepository.findById(login.getPassword());
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
	//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	//################################ My First Attempt #######################################
	//New attempt at cleaning up and combining above methods no need for checking user type here.
	//will need to return user or admin page on the front end currentUser object will have that in it.
	
//	public String signIn(Login login) {				
//		Optional<Login> varifyingUser = loginRepository.findById(login.getLoginid());
//		if(varifyingUser.isPresent()) {
//			String url = "http://localhost:8282/user/userVerification";
//			Login currentUser = restTemplate.postForObject(url, login, Login.class);
//				if(currentUser.getPassword().equals(login.getPassword()) && currentUser.getEmail().equals(login.getEmail())) {
//					return "Login sucessful";
//				}else {
//	
//						return "Wrong email or password";
//				}
//		}
//	}
	//#####################################################################
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@ My Second attempt @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	public String signIn(Login login){
//			String url = "http://localhost:8282/user/userVerification";
//			System.out.println("**********1");
//			String verifyingUser = restTemplate.postForObject(url, login, String.class);
//			System.out.println("***********2");
//			Optional<String> optionalVerifyingUser = Optional.of(verifyingUser);
//			String verifyMessage = Answer(optionalVerifyingUser);
//			return verifyMessage;
//			}
//		&&&&&&&&&&&&&&&&&&&&&&&&&&&&Added to my second attempt &&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	//Taking in a value in the form of a string and extracting that value to return appropriate login message
	
//		public String Answer(Optional<String> optionalVerifyUser) {
//			if (optionalVerifyUser.isEmpty()) {
//				return "Unknown Error contact your Administrator";
//			}
//		int messageNum = Integer.parseInt(optionalVerifyUser.get()); //look up switch statement for this method
//					
//							if (messageNum > 0) return "Successful Login";
//								
//							else if (messageNum < 0) return "Incorrect email or Password";
//								
//							else return "Error Value";
//		}
	//*****************************Current Attempt*******************************
	
	public String signIn(Login login){
		String url = "http://localhost:8282/user/userVerification";
		HttpHeaders headers = new HttpHeaders();
			headers.set("User-Agent", "Capstone-Travel");//do I send the login in the headers.... That doesn't seem like it would be very secure...
			headers.set("Custom-Identifyer", "Generated value");//but that could be a separate element to address at another time.
			
			headers.setAccept(List.of(MediaType.APPLICATION_JSON));
				HttpEntity<String> entity = new HttpEntity<>(headers);
				ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
				String verifyingUser = restTemplate.postForObject(url, login, String.class);
				return response.getBody();
		
		//String verifyingUser = restTemplate.postForObject(url, login, String.class);//need to add headers to return "name tag"
		//return verifyingUser; 
		// I still need this code otherwise I am not sending the login... ????
		}
	
//***************************************** Fourth Attempt *********************************************
//	public String verifyUser() {
//		String url = "http://localhost:8282/verifyUserLogin";
//		String response = restTemplate.postForObject(url, null, String.class);
//		return "Login " + response;
//	}
		
	public String signUp(Login login) { 
		Optional<Login> result = loginRepository.findById(login.getPassword());//Id should be userid not password.
		if(result.isPresent()) {
				return "That account already exists";
		}else {
			
			loginRepository.save(login);
			return "Account created successfully";
			}
		}
	}