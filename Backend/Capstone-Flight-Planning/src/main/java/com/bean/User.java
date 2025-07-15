package com.bean;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;

@Entity
@Component
public class User {
	@Id
	private String emailid;
	private String userfname;
	private String userlname;

	public User() {
		super();
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
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