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
public class Flight {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int flightid;
		private String emailid;
		private String userfname;
		private String userlname;
		private String origin;
		private String destination;
		//DateTime Arrival
		//DateTime Departure
		private String airline;
		private float price;
		
		public int getFlightid() {
			return flightid;
		}
		public void setFlightid(int flightid) {
			this.flightid = flightid;
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
