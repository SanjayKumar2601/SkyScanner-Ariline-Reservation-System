package com.virtusa.SkyScanner.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.SkyScanner.model.BookFlights;
import com.virtusa.SkyScanner.model.BookedTickets;

/** This interface is for Ticket Management  controller.
 * All implemented  */
public interface TicketManagmentController {

	ModelAndView searchBookFlight(@ModelAttribute BookFlights fs);
	ModelAndView bookFlightTickets(@ModelAttribute BookedTickets ticket);
	ModelAndView displayPayment();
	ModelAndView Payment();
	
	
	
	
}
