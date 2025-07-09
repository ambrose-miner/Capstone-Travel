package com.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bean.Ride;
@Repository
public interface RideRepository extends JpaRepository<Ride, Integer> {
	
//	@Query("select cf.distance from Fare cf where cf.pickup = :pickup and cf.dropoff = :dropoff")
//	public float findRidePrice(@Param("pickup") String pickup, @Param("dropoff") String dropoff);
}