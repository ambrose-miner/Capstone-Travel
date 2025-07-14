package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.bean.User;
import com.repository.UserRepository;

public class UserService {
@Autowired
UserRepository userRepository;
@Autowired
RestTemplate restTemplate;

public List<User> findAllUsers() {
	List<User> users = userRepository.findAll();
	return users;
	}
}
