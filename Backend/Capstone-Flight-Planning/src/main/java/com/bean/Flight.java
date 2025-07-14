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
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY);
	private int flightid;
	private String origin;
	private String destination;
	private Date arrival;
	private Date departure;
	private String airline;
	private float price;

	public Flight() {
		super();
	}

	public int getFlightid() {
		return flightid;
	}

	public void setFlightid(int flightid, FlightBooking flightBooking) {
		flightBooking.bookingid = flightid; //this was auto generated when I pulled the super class...??
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin, FlightBooking flightBooking) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination, FlightBooking flightBooking) {
		this.destination = destination;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline, FlightBooking flightBooking) {
		this.airline = airline;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price, FlightBooking flightBooking) {
		this.price = price;
	}

}