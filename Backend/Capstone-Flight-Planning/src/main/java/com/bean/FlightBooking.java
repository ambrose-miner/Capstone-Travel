package com.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
@Component
@Scope("prototype")
public class FlightBooking {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		private int bookingid;
		@ManyToOne
		@JoinColumn(name = "userid")
		private User user;
		@ManyToOne
		@JoinColumn(name = "flightid")
		private Flight flight;
		
	
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Flight getFlight() {
			return flight;
		}

		public void setFlight(Flight flight) {
			this.flight = flight;
		}

		public int getBookingid() {
			return bookingid;
		}

		public void setBookingid(int bookingid) {
			this.bookingid = bookingid;
		}
		
}
