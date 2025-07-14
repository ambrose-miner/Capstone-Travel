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
public class FlightBooking extends User {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int bookingid;

		public int getBookingid() {
			return bookingid;
		}

		public void setBookingid(int bookingid) {
			this.bookingid = bookingid;
		}
		
}
