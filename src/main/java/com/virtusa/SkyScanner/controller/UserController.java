package com.virtusa.SkyScanner.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.SkyScanner.model.Users;
/** This interface is for user controller.
 * All implemented  */
public interface UserController {
	ModelAndView getLogin(@RequestParam("email")String email,@RequestParam("password")String password);
	ModelAndView getHome();
	ModelAndView getSignupDetails(@ModelAttribute Users user);
	ModelAndView displayCheckin();
	ModelAndView getCheckinDetails(@RequestParam(name="tid") String tid);
	ModelAndView cancelTickets();
	ModelAndView cancelTicket(@RequestParam("ticketid") String tid);
	ModelAndView manage();
	ModelAndView setSeatMapping(@RequestParam(name="seats") String seats);
	ModelAndView Logout();
	
	
}
