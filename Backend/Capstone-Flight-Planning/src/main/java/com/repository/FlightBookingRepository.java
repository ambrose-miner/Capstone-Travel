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
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer>{

	void deleteFlightBooking(FlightBooking flightBooking);
	
	@Query(value = "SELECT * FROM FlightBooking",
			nativeQuery = true)
	List<FlightBooking> findByUser(@Param("user") User user);
	
	@Query(value = "SELECT * FROM FlightBooking",
			nativeQuery = true)
	List<FlightBooking> findByFlight(@Param("flight") Flight flight);
	
	@Query(value = "SELECT * FROM FlightBooking WHERE User = user && Flight.departure LIKE %:departure% && Flight.arrival LIKE %:arrival%",
			nativeQuery= true)
	List<FlightBooking> findUserFlightBookingByTravalDate(@Param("user, flight,")User user, Flight departure, Flight arrival);
}
