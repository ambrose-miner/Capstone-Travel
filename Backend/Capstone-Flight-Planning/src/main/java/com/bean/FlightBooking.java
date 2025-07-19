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
public class FlightBooking {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int bookingid;
		private User user; //  Find spring annotations for FK and database relationship
		private Flight flight;// Find spring annotations for FK and database relationship
		
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
