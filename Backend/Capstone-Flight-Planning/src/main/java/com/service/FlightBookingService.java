package com.service;
import java.sql.Date;
import java.time.LocalDate;
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
	
	public String bookFlight(int flightid, User userCurrent) {
		Optional<Flight> optionalFlight = flightRepository.findById(flightid);
		if (optionalFlight.isPresent()){
			Flight workingFlight = optionalFlight.get();
			FlightBooking flightBooking = new FlightBooking(workingFlight, userCurrent);
			flightBookingRepository.save(flightBooking);
			System.out.println("book flight calling repository");
			return "Your flight has been booked successfully";
		}else {
			return "Flight Booking Error";	
		}
		
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
	public List<FlightBooking> findUserFlightBookingByDepartureDate(Long userid, LocalDate departure){
		List<FlightBooking> userBookedTravel = flightBookingRepository.findUserFlightBookingByDepartureDate(userid, departure);
		return userBookedTravel;
	}
	public List<FlightBooking> findUserFlightBookingByArrivalDate(Long userid, LocalDate arrival){
		List<FlightBooking> userBookedTravel = flightBookingRepository.findUserFlightBookingByArrivalDate(userid, arrival);
		return userBookedTravel;
	}
	
	public String deleteFlightBooking(int bookingId) {
		flightBookingRepository.deleteById(bookingId);
		return "Flight booking has been canceled";
	}
}
	
