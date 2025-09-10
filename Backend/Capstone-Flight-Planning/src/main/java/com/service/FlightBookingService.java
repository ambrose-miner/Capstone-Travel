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

@Service
public class FlightBookingService {
	//private final RestTemplate restTemplate;//New
	@Autowired
	FlightBookingRepository flightBookingRepository;
//	@Autowired											//New /Speculative
//	public FlightBookingService (RestTemplate restTemplate) {//New
//		this.restTemplate = restTemplate;//New
		
	//***Old Version
	@Autowired
	RestTemplate restTemplate;
	
	public String bookFlight(FlightBooking flightBooking) {
		flightBookingRepository.save(flightBooking);
		System.out.println("book flight calling repository");
		return "Your flight has been booked successfully";
	}
	
	public List<FlightBooking> findAllFlightBooking() {
		List<FlightBooking> bookedFlights = flightBookingRepository.findAll();
		return bookedFlights;
	}
	
	public List<FlightBooking> findUserFlightBooking(Long userid) { 					
		List<FlightBooking> userBookings = flightBookingRepository.findAllById(userid);
		return userBookings;												
	}
	public List<FlightBooking> findUserFlightBookingAdmin(Long userid) {
		List<FlightBooking> userBookings = flightBookingRepository.findAllById(userid);
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
	public List<FlightBooking> findBookingsOnFlightById(int flightid) {
		List<FlightBooking> flightBookings = flightBookingRepository.findBookingsOnFlightById(flightid);
		return flightBookings;
	}
	public String deleteFlightBooking(FlightBooking flightBooking) {
		flightBookingRepository.delete(flightBooking);
		return "Flight booking has been deleted";
	}
}
	
