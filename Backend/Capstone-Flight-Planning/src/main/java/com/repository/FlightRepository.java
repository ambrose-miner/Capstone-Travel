package com.repository;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.Flight;
import com.bean.FlightBooking;
import com.bean.User;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>{
	
	@Query(value = "SELECT * FROM Flight WHERE flight.bookingid = :bookingid", nativeQuery = true)//rework for true find by flight booking params
	Optional<Flight> findByFlightBooking(
			@Param("bookingid") int bookingid);
	
	@Query(value = "SELECT * FROM Flight WHERE flight.origin = :origin AND Flight.destination = :destination", nativeQuery = true)
	List<Flight> findFlightsByOriginAndDestination(
			@Param("origin") String origin, 
			@Param("destination") String destination);
	
	@Query(value = "SELECT * FROM Flight WHERE origin = :origin AND destination = :destination AND departure = :departure",
			nativeQuery = true)//This query returns the appropriate list.
	List<Flight> findFlightsByOriginAndDestinationAndDepartureDate(
			@Param("origin") String origin,
			@Param("destination") String destination,
			@Param("departure") Date departure);
	
	@Query(value = "SELECT * FROM Flight WHERE origin = :origin AND destination = :destination AND arrival = :arrival",
			nativeQuery = true)//This Query returns an empty list. SQL run on command line returns the appropriate list.
								//Removed the fields one by one select all from Flight returns all flights
								//select * from Flight where arrival = :arrival also returns the appropriate list.
								//How can the previous Query work and this one does not.
	List<Flight> findFlightsByOriginAndDestinationAndArrivalDate(
			@Param("origin") String origin, 
			@Param("destination") String destination,
			@Param("arrival") Date arrival);
	
	@Query(value = "SELECT * FROM Flight_Booking WHERE flightid = :flightid",nativeQuery = true)			
	List<FlightBooking> findBookingsOnFlightById(
			@Param("flightid") int flightid);
}

