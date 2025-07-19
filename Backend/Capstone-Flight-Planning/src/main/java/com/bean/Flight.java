package com.bean;

import java.sql.Date;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

//org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]:
//Entity 'com.bean.Flight' has no identifier (every '@Entity' class must declare or inherit at least one '@Id' or '@EmbeddedId' property)


//Caused by: org.hibernate.AnnotationException: Entity 'com.bean.Flight' has no identifier 
	//(every '@Entity' class must declare or inherit at least one '@Id' or '@EmbeddedId' property)
@Entity
@Component
@Scope("prototype")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightid;
	private String origin;
	private String destination;
	private Date arrival;
	private Date departure;
	private String airline;
	private float price;
	
	public int getFlightid() {
		return flightid;
	}
	public void setFlightid(int flightid) {
		this.flightid = flightid;
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
	public Date getArrival() {
		return arrival;
	}
	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}
	public Date getDeparture() {
		return departure;
	}
	public void setDeparture(Date departure) {
		this.departure = departure;
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