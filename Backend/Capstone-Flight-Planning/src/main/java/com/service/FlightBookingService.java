package com.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bean.User;
import com.bean.Flight;
import com.bean.FlightBooking;
import com.repository.FlightBookingRepository;

@Service
public class FlightBookingService {
	@Autowired
	FlightBookingRepository flightBookingRepository;
	@Autowired
	RestTemplate restTemplate;
	
	public String bookFlight(FlightBooking fB) {
		flightBookingRepository.save(fB);
		System.out.println("book flight calling repository");
		return "Your flight has been booked successfully";
//		float amount = restTemplate.getForObject("http://localhost:8282/price/findPrice/"+fB.getOrigin()+"/"+fB.getDestination(), Float.class);
//		if(amount==-1) {
//			return "No Flights are avaiable with origin location as "+fB.getOrigin()+" and destination as "+fB.getDestination();
//		}else {
//			fB.setPrice(amount, fB); 
//			flightBookingRepository.save(fB);
//			System.out.println("book flight calling repository");
//			return "Your flight has been booked successfully"; Old method... do not need price return based on destination.
	
	}
	public List<FlightBooking> findAllFlightBooking() {
		List<FlightBooking> bookedFlights = flightBookingRepository.findAll();
		return bookedFlights;
	}

	public List<FlightBooking> findUserFlightBooking(User user) { // passing user object to flightBookingRepository.
		List<FlightBooking> userBookings = flightBookingRepository.findById(user); //does not like this. I need a "for each" in here...??
		return userBookings;
	}
	public void deleteFlightBooking(FlightBooking flightBooking) {
		flightBookingRepository.deleteFlightBooking(flightBooking);
	}
}
	
