package com.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import com.bean.User;//Is this needed? public FlightBooking constructor displayed an error until I put this in... but now says its unused.
//same constructor was working previously to putting this in. Eclipse bug?

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
		
		public FlightBooking(Flight flight, User user) {
			this.flight = flight;
			this.user = user;
		}
		public FlightBooking() {
		}
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
