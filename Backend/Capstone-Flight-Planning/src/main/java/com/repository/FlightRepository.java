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
	
	@Query(value = "SELECT * FROM flight", nativeQuery = true)
	List<Flight> findByFlightBooking(@Param("flightBooking") FlightBooking flightBooking);
}

