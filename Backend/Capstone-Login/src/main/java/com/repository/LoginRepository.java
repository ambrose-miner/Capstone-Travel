package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.Login;
//import com.bean.User;

@Repository
public interface LoginRepository extends JpaRepository<Login, Object>{//changed to Object from String... Login is not a string how did that happen?
																				//This neither way makes Login work.

}