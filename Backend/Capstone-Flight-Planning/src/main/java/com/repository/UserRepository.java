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
public interface UserRepository extends JpaRepository<User, Integer>{

	//void deleteUser(User user); //Not Needed throws error.
	
	
	@Query(value = "SELECT * FROM user", nativeQuery = true)
	List<User> findUsersOnFlight(@Param("flight") Flight flight);
}
