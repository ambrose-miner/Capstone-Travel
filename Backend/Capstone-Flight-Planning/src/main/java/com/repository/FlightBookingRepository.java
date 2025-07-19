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
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer>{

	void deleteFlightBooking(FlightBooking flightBooking);//do I need this method? Do I need one comparable for create? 
														//Arn't they both handled by Springboot?
	
	@Query(value = "SELECT * FROM FlightBooking",
			nativeQuery = true)
	List<FlightBooking> findByUser(@Param("user") User user);
	
	@Query(value = "SELECT * FROM FlightBooking WHERE User = :user AND Flight.departure LIKE %:departure% AND Flight.arrival LIKE %:arrival%",
			nativeQuery= true)																		
	List<FlightBooking> findUserFlightBookingByTravalDate(@Param("user")User user, @Param("departure") Date departure, @Param("arrival") Date arrival);
	
	@Query(value = "SELECT * FROM FlightBooking",
			nativeQuery = true)
	List<FlightBooking> findByFlight(@Param("flight") Flight flight);
	
}