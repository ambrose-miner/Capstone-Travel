package com.bean;

import java.sql.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Component
@Scope("prototype")
public class FlightBooking {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int bookingid; //Foreign key for user's booking
		private int flightid; //Foreign key for flight object
		private String emailid; //user specific // should there be a separate user object??? 
		//Same object could be used for Ride booking A user HAS bookings and user can view all their bookings...
		private String userfname; //user specific
		private String userlname; //user specific
		private String origin; //part of flight object
		private String destination; //part of flight object
		private Date Arrival; //part of flight object
		private Date Departure; //part of flight object
		private String airline; //part of flight object
		private float price; //user specific
		//move flight object stuff in to flight object and user specific items stay in flight booking
		//making two tables in mysql flights and bookings flight list can be viewed without pulling all the booking information
		public int getFlightid() {
			return bookingid;
		}
		public void setFlightid(int flightid) {
			this.bookingid = flightid;
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
		public String getOrigin() {
			return origin;
		}
		public void setOrigin(String origin) {
			this.origin = origin;
		}
		public String getDestination() {
			return destination;
		}
		public void setDestination(String destination) {
			this.destination = destination;
		}
		public String getAirline() {
			return airline;
		}
		public void setAirline(String airline) {
			this.airline = airline;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		
}
