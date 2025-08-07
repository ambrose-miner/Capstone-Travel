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
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query(value = "SELECT * FROM User", nativeQuery = true)
	List<User> findUsersOnFlight(@Param("flight") Flight flight);

	@Query(value = "SELECT flight.departure FROM Flight WHERE User = :user", nativeQuery = true)
	List<Date> findUserDepartureDates(@Param("user") User user);
	
	@Query(value = "SELECT flight.arrival FROM Flight WHERE User = :user", nativeQuery = true)
	List<Date> findUserArrivalDates(@Param("user") User user);
}