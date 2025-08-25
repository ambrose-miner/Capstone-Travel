package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.Login;
//import com.bean.User;

@Repository
public interface LoginRepository extends JpaRepository<Login, String>{

}