package com.suraj.flightReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suraj.flightReservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	//We are finding the Email in the DB
	//And returning the User Object related to that Email
	//Return False message if user not found, or Password is incorrect
	User findByUserName(String email);

}
