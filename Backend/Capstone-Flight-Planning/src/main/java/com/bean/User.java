package com.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Component
@Scope("prototype")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;
	private String email;
	private String userfname;
	private String userlname;

	public User() {
		super();
	}

	
	public Long getUserid() {
		return userid;
	}


	public void setUserid(Long userid) {
		this.userid = userid;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUserfname() {
		return userfname;
	}

	public void setUserfname(String userfname) {
		this.userfname = userfname;
	}

	public String getUserlname() {
		return userlname;
	}

	public void setUserlname(String userlname) {
		this.userlname = userlname;
	}

}