package com.bean;

import java.sql.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
//Error 1
//org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]:
//Entity 'com.bean.Flight' has no identifier (every '@Entity' class must declare or inherit at least one '@Id' or '@EmbeddedId' property)

//Error 2
//Caused by: org.hibernate.AnnotationException: Entity 'com.bean.Flight' has no identifier 
	//(every '@Entity' class must declare or inherit at least one '@Id' or '@EmbeddedId' property)
//Error 3
//Caused by: org.hibernate.AnnotationException: Property 'com.bean.Flight.flightid'
//is not a collection and may not be a '@OneToMany', '@ManyToMany', or '@ElementCollection'
//Error 4
//Caused by: java.lang.NullPointerException: Cannot invoke "org.hibernate.mapping.KeyValue.getSelectables()"
//because the return value of "org.hibernate.mapping.PersistentClass.getKey()" is null
@Entity
@Component
@Scope("prototype")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightid;
	@OneToMany(mappedBy = "bookingid")// These lines seemed to have fixed Errors 1 and 2
	// Moving this line here from its previous position bellow List<FlightBooking> caused it to go back to error 3
	private List<FlightBooking> FlightBooking; //After this line was added went from error 3 to error 4.
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