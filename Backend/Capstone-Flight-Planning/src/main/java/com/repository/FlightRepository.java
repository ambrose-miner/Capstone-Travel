package com.repository;

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
	
	@Query(value = "SELECT * FROM Flight WHERE flight.origin = origin && Flight.destination = destination", nativeQuery = true)
	List<Flight> searchFlightsByOriginAndDestination(@Param("flight") Flight origin, Flight destination);
	
	@Query(value = "SELECT * FROM Flight WHERE flight.origin = origin && Flight.destination = destination && Flight.departure = departure",
			nativeQuery = true)
	List<Flight> searchFlightsByDepartureDateAndOriginAndDestination(@Param("flight") Flight origin, Flight destination, Flight departure);
	
	@Query(value = "SELECT * FROM Flight WHERE flight.origin = origin && Flight.destination = destination && Flight.arrival = arrival",
			nativeQuery = true)
	List<Flight> searchFlightsByDepartureDateAndOriginAndArrival(@Param("flight") Flight origin, Flight destination, Flight arrival);
}

