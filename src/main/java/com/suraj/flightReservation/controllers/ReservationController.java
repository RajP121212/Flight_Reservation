package com.suraj.flightReservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.suraj.flightReservation.dataTransferObject.ReservationRequest;
import com.suraj.flightReservation.entities.Flight;
import com.suraj.flightReservation.entities.Reservation;
import com.suraj.flightReservation.repository.FlightRepository;
import com.suraj.flightReservation.service.IReservationService;

@Controller
public class ReservationController {

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private IReservationService reservationService;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {

		Flight flight = flightRepository.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		return "showCompleteReservation";
	}

	@RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest reservationRequest, ModelMap modelMap) {
		
		Reservation reservation = reservationService.bookFlight(reservationRequest);
		modelMap.addAttribute("msg", "Reservation Created Successfully and the id is: " + reservation.getId());
		
		return "reservationConfirmation";
	}

}
