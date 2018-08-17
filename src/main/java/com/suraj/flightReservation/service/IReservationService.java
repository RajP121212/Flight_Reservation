package com.suraj.flightReservation.service;

import com.suraj.flightReservation.dataTransferObject.ReservationRequest;
import com.suraj.flightReservation.entities.Reservation;

public interface IReservationService {
	
	public Reservation bookFlight(ReservationRequest reservationRequest);

}
