package com.suraj.flightReservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.flightReservation.dataTransferObject.UpdateReservationRequest;
import com.suraj.flightReservation.entities.Reservation;
import com.suraj.flightReservation.repository.ReservationRepository;

@RestController
public class ReservationRESTController {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		return reservationRepository.findById(id).get();
	}
	
	//@RequestBody: Tells Spring that at Runtime, construct the object(UpdateReservationRequest) with the content that comes in the request
	//content in the request here is the JSON
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody UpdateReservationRequest request) {
		Reservation reservation = reservationRepository.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		
		return reservationRepository.save(reservation);
	}
	
}
