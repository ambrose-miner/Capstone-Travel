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
	
	@Query(value = "SELECT * FROM Flight_Booking WHERE userid = :userid",
			nativeQuery = true)
	List<FlightBooking> findAllById(
			@Param("userid") Long userid);
	// Commented out method that uses these queries is broken and prevents the build.
//	@Query(value = "SELECT * FROM Flight_Booking WHERE User = :user AND Flight.departure LIKE %:departure% AND Flight.arrival LIKE %:arrival%")
//	@Query(value = "SELECT * FROM Flight_Booking WHERE User = :user AND (Flight.departure) = :departure AND (Flight.arrival) = :arrival")
//	List<FlightBooking> findUserFlightBookingByTravalDate(
//			@Param("user")User user, 
//			@Param("departure") Date departure, 
//			@Param("arrival") Date arrival);
	
	@Query(value = "SELECT * FROM Flight_Booking WHERE Flight = :flight",
			nativeQuery = true)
	List<FlightBooking> findBookingsOnFlight(
			@Param("flight") Flight flight);
	
}