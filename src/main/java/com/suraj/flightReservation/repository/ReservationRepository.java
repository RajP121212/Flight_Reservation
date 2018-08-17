package com.suraj.flightReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suraj.flightReservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
