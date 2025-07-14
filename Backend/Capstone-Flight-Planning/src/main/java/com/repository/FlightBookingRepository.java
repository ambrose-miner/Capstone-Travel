package com.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bean.FlightBooking;
import com.bean.User;
@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer>{

	FlightBooking findByUser(Object User); //will this work? Seems way to simple... mirroring an online example.
}
