package com.suraj.flightReservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.suraj.flightReservation.entities.User;
import com.suraj.flightReservation.repository.UserRepository;
import com.suraj.flightReservation.service.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		return "login/registerUser";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "login/login";
	}
	
	@RequestMapping("/showLogin")
	public String showLoginPage() {
		return "login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String findUserByEmail(@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "password", required = true) String password,
			ModelMap modelMap) {
		
		User user = userRepository.findByUserName(userName);
		if(user.getPassword().equals(password)) {
			return "findFlights";
		}
		else {
			modelMap.addAttribute("msg", "Invalid User Name or Password. Please Try Again!!");
		}
		return "login/login";
	}

}
