package com.repository;


import java.time.LocalDate;
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
	
	@Query(value = "SELECT * FROM Flight WHERE flight.bookingid = :bookingid", nativeQuery = true)
	//rework for true find by flight booking params/keep as admin method
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
			@Param("departure") LocalDate departure);
	
	@Query(value = "SELECT * FROM Flight WHERE origin = :origin AND destination = :destination AND arrival = :arrival",
			nativeQuery = true)
	List<Flight> findFlightsByOriginAndDestinationAndArrivalDate(
			@Param("origin") String origin, 
			@Param("destination") String destination,
			@Param("arrival") LocalDate arrival);
	
	@Query(value = "SELECT * FROM Flight_Booking WHERE flightid = :flightid",nativeQuery = true)			
	List<FlightBooking> findBookingsOnFlightById(
			@Param("flightid") int flightid);
}

