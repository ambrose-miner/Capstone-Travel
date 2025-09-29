package com.service;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bean.User;
import com.bean.Flight;
import com.bean.FlightBooking;
import com.repository.FlightBookingRepository;
import com.repository.FlightRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class FlightBookingService {
	@Autowired
	FlightBookingRepository flightBookingRepository;
	@Autowired
	FlightRepository flightRepository;
	@Autowired
	private HttpSession session;
	@Autowired
	RestTemplate restTemplate;
	
	public String bookFlight(int flightid, User userCurrent) {//Taking in userid and flightid to create a flightBooking
		Optional<Flight> workingFlight = flightRepository.findById(flightid);
		if (workingFlight.isPresent()){
			Flight toBook = workingFlight.get();
			FlightBooking flightBooking = new FlightBooking(toBook, userCurrent);
			flightBookingRepository.save(flightBooking);
			System.out.println("book flight calling repository");
			return "Your flight has been booked successfully";
		}else {
			return "Flight Booking Error";
			
			
		}
		
		
		//Error "The constructor FlightBooking(int, Long) is undefined" What am I missing here?
		//Flightbooking is only Flights and Users do I need to find those Objects by Id first and save it
		//That seems there should be a better way....?
		
		
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
	
