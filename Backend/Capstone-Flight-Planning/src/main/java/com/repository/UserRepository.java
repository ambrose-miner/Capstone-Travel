package com.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.Flight;
import com.bean.FlightBooking;
import com.bean.Login;
import com.bean.User;

import jakarta.ws.rs.Path;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query(value = "SELECT * FROM User WHERE password = :password AND email = :email", nativeQuery = true)
	Optional<User>  verifyUser(
						@Param("password") String password,
						@Param("email")String email);
	
	@Query(value = "SELECT UserId FROM User WHERE password = :password AND email = :email", nativeQuery = true)
	Optional<Long> getUserId(
			@Param("password") String password,
			@Param("email")String email);
			
	@Query(value = "SELECT * FROM User", nativeQuery = true)
	List<User> findUsersOnFlight(@Param("flight") int flightid);

	@Query(value = "SELECT flight.departure FROM Flight WHERE User = :userid", nativeQuery = true)
	List<Date> findUserDepartureDates(@Param("user") Long userid);
	
	@Query(value = "SELECT flight.arrival FROM Flight WHERE User = :userid", nativeQuery = true)
	List<Date> findUserArrivalDates(@Param("user") Long userid);
}