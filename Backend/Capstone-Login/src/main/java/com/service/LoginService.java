package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bean.Login;
import com.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	@Autowired
	RestTemplate restTemplate;
	
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
//		int messageNum = Integer.parseInt(optionalVerifyUser.get());
//					
//							if (messageNum > 0) return "Successful Login";
//								
//							else if (messageNum < 0) return "Incrorrect email or Password";
//								
//							else return "Error Value";
//		}
	//*****************************3 new methods*******************************
	//sign in will just call the method in user service
	//The other two methods will return messages depending on whitch one is called from user service.
	//No logic required in Login service and no user info needed all taken care of in user service.
	public void signIn(Login login){
		String url = "http://localhost:8282/user/userVerification";
		String verifyingUser = restTemplate.postForObject(url, login, String.class);
		Optional<String> optionalVerifyingUser = Optional.of(verifyingUser);
		}
	public String successfulLogin(Optional<String> optionalUserVerification) {	
		if (optionalUserVerification.isEmpty()) {
			return "Unknown Error contact your Administrator";
		}else {
			return "Successful Login";
		}
	}	
		public String failedLogin(Optional<String> optionalUserVerification) {	
			if (optionalUserVerification.isEmpty()) {
				return "Unknown Error contact your Administrator";
			}else {
				return "Incrorrect email or Password";
			}
		}

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