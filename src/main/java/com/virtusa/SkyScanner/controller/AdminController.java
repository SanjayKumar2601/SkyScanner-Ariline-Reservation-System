package com.virtusa.SkyScanner.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.SkyScanner.model.Flights;

/** This interface is for admin controller.
 * All implemented  */
public interface AdminController {
	
	public ModelAndView getAdminLoginDetails(@RequestParam("email")String email,@RequestParam("password")String password);
	ModelAndView setFlightDetails(@ModelAttribute Flights flight);
	ModelAndView adminHome();
	ModelAndView adminRemoveFligths();
	ModelAndView adminRemoveFlight(@RequestParam(name="f") String f) ;
	ModelAndView adminViewUsers();
	ModelAndView adminViewFligths();
}
