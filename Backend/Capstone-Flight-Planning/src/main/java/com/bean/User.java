package com.bean;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@Component
@Scope("prototype")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;
//	@OneToOne( cascade = CascadeType.ALL,  fetch = FetchType.LAZY)//this is ALL!!
//	@JoinColumn(name = "loginid")
//	private Login login;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)//not all will revise.
	private List<FlightBooking>FlightBooking;
	private String password;//Components of Login
	private String email;//Components of Login
	private String userfname;
	private String userlname;
	private String usertype;
	
	public User() {
		super();
	}
//	public Login getLogin() {
//		return login;
//	}
//	public void setLogin(Login login) {
//		this.login = login;
//	}
	public List<FlightBooking> getFlightBooking() {
		return FlightBooking;
	}
	public void setFlightBooking(List<FlightBooking> flightBooking) {
		FlightBooking = flightBooking;
	}
	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
