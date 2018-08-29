package com.suraj.flightReservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suraj.flightReservation.dataTransferObject.ReservationRequest;
import com.suraj.flightReservation.entities.Flight;
import com.suraj.flightReservation.entities.Passenger;
import com.suraj.flightReservation.entities.Reservation;
import com.suraj.flightReservation.repository.FlightRepository;
import com.suraj.flightReservation.repository.PassengerRepository;
import com.suraj.flightReservation.repository.ReservationRepository;
import com.suraj.flightReservation.util.EmailUtil;
import com.suraj.flightReservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements IReservationService {
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private PDFGenerator pdfGenerator;
	
	@Autowired
	private EmailUtil emailUtil;

	@Override
	public Reservation bookFlight(ReservationRequest reservationRequest) {
		
		//Typically we would be to make a payment, but not going to do that at the moment
		//We can invoke a payment gateway web service
		//We will usually land on a 3rd party software, and that is where the payment will be processed
		
		//Make Payment
		//If payment fails throw an exception, this is currently not implemented
		
		//If payment is successful then, retrieve flight information
		//Get flight id, but we need entire Flight Object
		Long flightId = reservationRequest.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();
		
		//After getting the Flight Object we need to get the Passenger Object
		Passenger passenger = new Passenger();
		passenger.setFirstName(reservationRequest.getPassengerFirstName());
		passenger.setLastName(reservationRequest.getPassengerLastName());
		passenger.setMiddleName(reservationRequest.getPassengerMiddleName());
		passenger.setUserName(reservationRequest.getPassengerEmail());
		passenger.setPhone(reservationRequest.getPassengerPhone());
		
		//After getting these fields we need to Inject the Passenger into the DB
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		//After saving the Passenger Object, we have to retrieve the Reservation
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		//Set Checked in to False
		//Once passenger checks in this flag will be set to True
		//We will set the flag to True in the Check in Module
		reservation.setCheckedIn(false);
		
		//Now we need the ReservationRepository to save the reservation
		Reservation savedReservation = reservationRepository.save(reservation);
		
		//Send the Email
		String filePath = "C:\\Users\\PIL3985\\Documents\\Reservations\\Reservation" + savedReservation.getId() + ".pdf";
		pdfGenerator.generateItinerary(savedReservation, filePath);
		
		emailUtil.sendItinerary(passenger.getUserName(), filePath);
		
		return savedReservation;
	}

}
