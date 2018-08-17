package com.suraj.flightReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suraj.flightReservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
