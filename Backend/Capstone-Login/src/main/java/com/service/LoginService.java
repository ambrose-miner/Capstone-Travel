package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Login;
import com.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	
	public String signIn(Login login) {		//Login should just be email and password. User has login one to one relationship
											//Type of user and userid should be user characteristics.
		//Here we should get in email and password and return a user object 
		//stored in the rest template/session to be accessed by any other elements or micro services that need it specifically userid and usertype 
		Optional<Login> result = loginRepository.findById(login.getUserid());// This is finding user by Id right?
		if(result.isPresent()) {											// Will I need a copy of User bean here as well?
							//I would think yes so it can query the data base and fill out that object?
			Login ll = result.get();			// ll hold email, password and typeofuser from db.
												// will be taking email and password and getting userid and typeofuser from db.
					if(ll.getPassword().equals(login.getPassword())) {
						
							if(ll.getTypeofuser().equals(login.getTypeofuser()) && login.getTypeofuser().equals("admin")) {
								return "Admin login";//must get type of user from User not login.
							}else if(ll.getTypeofuser().equals(login.getTypeofuser()) && login.getTypeofuser().equals("customer")) {
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
	
	public String signUp(Login login) {		// emailid, password and typeof user if type of user is admin can't create account. 
		Optional<Login> result = loginRepository.findById(login.getUserid());
		if(result.isPresent()) {
				return "That account already exists";
		}else {
			if(login.getTypeofuser().equals("admin")) {
				return "You can't create admin account";
			}else {
			loginRepository.save(login);
			return "Account created successfully";
			}
		}
	}
}