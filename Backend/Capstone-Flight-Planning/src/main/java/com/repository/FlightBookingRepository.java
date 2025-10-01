package com.repository;
import java.sql.Date;
import java.time.LocalDate;
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
	 
	@Query(value = "SELECT * FROM Flight_Booking WHERE User = :user AND (Flight.departure) = :departure",nativeQuery = true)
	List<FlightBooking> findUserFlightBookingByDepartureDate(
			@Param("userid")Long userid, 
			@Param("departure") LocalDate departure);
	
	@Query(value = "SELECT * FROM Flight_Booking WHERE User = :user AND (Flight.arrival) = :arrival",nativeQuery = true)
	List<FlightBooking> findUserFlightBookingByArrivalDate(
			@Param("userid")Long userid, 
			@Param("arrival") LocalDate arrival);		
	
	
	
}