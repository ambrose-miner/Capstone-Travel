package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.User;
import com.service.LoginService;


@RequestMapping("/login")// added /before login
@CrossOrigin			// allowing front end technologies to access that data.
public class LoginController {
	
	@Autowired
	LoginService loginService;

	
	// http://localhost:8181/Capstone-login/signIn  //This should be the correct path and port number.
	@PostMapping(value = "signIn",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signIn(@RequestBody User user) {
		return loginService.signIn(user);
	}
	// http://localhost:8181/Capstone-login/signUp //This should be the correct path and port number.
	@PostMapping(value = "signUp",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signUp(@RequestBody User user) {
		return loginService.signUp(user);
	}
}