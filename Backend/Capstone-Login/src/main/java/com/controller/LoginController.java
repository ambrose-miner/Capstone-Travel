package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Login;
import com.service.LoginService;

@RestController
@RequestMapping("/login")
@CrossOrigin			// allowing front end technologies to access that data.
public class LoginController {
	
	@Autowired
	LoginService loginService;

	
	// http://localhost:8181/Capstone-login/login/signIn  //This should be the correct path and port number.
	@PostMapping(value = "/signIn",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signIn(@RequestBody Login login) {
		String response = loginService.signIn(login);
		return response;
	}
	// http://localhost:8181/Capstone-login/login/signUp //This should be the correct path and port number.
	@PostMapping(value = "/signUp",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signUp(@RequestBody Login login) {
		return loginService.signUp(login);
	}
	//******************** Added for Fourth Attempt***************************
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	@PostMapping("/login")
	public String login() {
		return loginService.verifyUser();
	}
}