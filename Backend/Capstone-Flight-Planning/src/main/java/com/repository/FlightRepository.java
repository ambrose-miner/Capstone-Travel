package com.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.Flight;
import com.bean.FlightBooking;
import com.bean.User;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>{
	
	@Query(value = "SELECT * FROM Flight", nativeQuery = true)
	List<Flight> findByFlightBooking(@Param("flightBooking") FlightBooking flightBooking);
	
	@Query(value = "SELECT * FROM Flight WHERE flight.origin = :origin AND Flight.destination = :destination", nativeQuery = true)
	List<Flight> findByFlightsByOriginAndDestination(
			@Param("origin") String origin, 
			@Param("destination") String destination);
	
	@Query(value = "SELECT * FROM Flight WHERE flight.origin = :origin AND Flight.destination = :destination AND Flight.departure = :departure",
			nativeQuery = true)
	List<Flight> findByFlightsByOriginAndDestinationAndByDepartureDate(
			@Param("origin") String origin,
			@Param("destination") String destination,
			@Param("departure") Date departure);
	
	@Query(value = "SELECT * FROM Flight WHERE flight.origin = :origin AND Flight.destination = :destination AND Flight.arrival = :arrival",
			nativeQuery = true)
	List<Flight> findByFlightsByOriginAndDestinationAndArrivalDate(
			@Param("origin") String origin, 
			@Param("destination") String destination,
			@Param("arrival") Date arrival);
}

