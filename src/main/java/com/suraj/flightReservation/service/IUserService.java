package com.suraj.flightReservation.service;

import java.util.List;

import com.suraj.flightReservation.entities.User;

public interface IUserService {
	
	User saveUser(User user);
	
	User updateUser(User user);
	
	void deleteUser(User user);
	
	User getUserById(Long id);
	
	List<User> getAllUsers();

}
