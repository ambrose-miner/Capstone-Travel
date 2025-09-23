package com.service;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bean.User;
import com.bean.Flight;
import com.bean.FlightBooking;
import com.repository.FlightBookingRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class FlightBookingService {
	@Autowired
	FlightBookingRepository flightBookingRepository;
	@Autowired
	private HttpSession session;
	@Autowired
	RestTemplate restTemplate;
	
	public String bookFlight(FlightBooking flightBooking, Long userid) {//Test to see if this works remove old bookings.
		flightBookingRepository.save(flightBooking);
		System.out.println("book flight calling repository");
		return "Your flight has been booked successfully";
	}
	
	public List<FlightBooking> findAllFlightBooking() {
		List<FlightBooking> bookedFlights = flightBookingRepository.findAll();
		return bookedFlights;
	}
	
	public List<FlightBooking> findUserFlightBooking(Long userid) { 
		User userCurrent = (User) session.getAttribute("userCurrent");
		userid = userCurrent.getUserid();
		List<FlightBooking> userBookings = flightBookingRepository.findAllById(userid);
		return userBookings;												
	}
	public List<FlightBooking> findUserFlightBookingAdmin(Long userid) {
		List<FlightBooking> userBookings = flightBookingRepository.findAllById(userid);//Admin does not get userid from the session.
		return userBookings;
	}
	public List<FlightBooking> findUserFlightBookingByDepartureDate(Long userid, Date departure){
		List<FlightBooking> userBookedTravel = flightBookingRepository.findUserFlightBookingByDepartureDate(userid, departure);
		return userBookedTravel;
	}
	public List<FlightBooking> findUserFlightBookingByArrivalDate(Long userid, Date arrival){
		List<FlightBooking> userBookedTravel = flightBookingRepository.findUserFlightBookingByArrivalDate(userid, arrival);
		return userBookedTravel;
	}
	
	public String deleteFlightBooking(FlightBooking flightBooking) {
		flightBookingRepository.delete(flightBooking);
		return "Flight booking has been canceled";
	}
}
	
