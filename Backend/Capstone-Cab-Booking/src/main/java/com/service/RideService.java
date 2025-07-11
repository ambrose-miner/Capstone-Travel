package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.repository.RideRepository;
import com.bean.Ride;

@Service
public class RideService {

	@Autowired
	RideRepository rideRepository;
	@Autowired
	RestTemplate restTemplate;

	public String bookRide(Ride rI) {
		float amount = restTemplate.getForObject("http://localhost:8383/fare/findFare/"+rI.getPickup()+"/"+rI.getDropoff(), Float.class);
		if(amount==-1) {
			return "No Cab are avaiable with pickup location as "+rI.getPickup()+" and dropoff destination as "+rI.getDropoff();
		}else {
			rI.setPrice(amount); 
			rideRepository.save(rI);
			return "Your cab book successfully";
		}
//		Optional<Ride> result = rideRepository.findById(rI.getRideId());	
//		if(result.isPresent()) {
//		return "This Ride is Already Booked";
//		
//		}else {
//			RideRepository.save(rI);
//			return "Ride Information stored";
//		}
	}
	//public String bookRide(Ride rI)
}
