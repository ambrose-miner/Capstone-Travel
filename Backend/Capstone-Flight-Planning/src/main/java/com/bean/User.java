package com.bean;

public class User extends Flight {

	private String emailid;
	private String userfname;
	private String userlname;

	public User() {
		super();
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid, FlightBooking flightBooking) {
		this.emailid = emailid;
	}

	public String getUserfname() {
		return userfname;
	}

	public void setUserfname(String userfname, FlightBooking flightBooking) {
		this.userfname = userfname;
	}

	public String getUserlname() {
		return userlname;
	}

	public void setUserlname(String userlname, FlightBooking flightBooking) {
		this.userlname = userlname;
	}

}