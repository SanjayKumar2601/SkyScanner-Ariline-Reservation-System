package com.virtusa.SkyScanner.controllerImpl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//import com.virtusa.SkyScanner.controller.TicketManagmentController;
import com.virtusa.SkyScanner.model.BookFlights;
import com.virtusa.SkyScanner.model.BookedTickets;
import com.virtusa.SkyScanner.model.CheckIn;
import com.virtusa.SkyScanner.model.Flights;
import com.virtusa.SkyScanner.model.Users;
import com.virtusa.SkyScanner.serviceImpl.CheckinServiceImpl;
import com.virtusa.SkyScanner.serviceImpl.FlightBookingServiceImpl;
import com.virtusa.SkyScanner.serviceImpl.FlightServicesImpl;
import com.virtusa.SkyScanner.serviceImpl.UserServiceImpl;
import com.virtusa.SkyScanner.serviceImpl.LoginServicesImpl;

/** This controller is for managing all the mapping request for booking the ticket
 */
@RestController
public class TicketManagmentControllerImpl {
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	FlightServicesImpl flightService;
	
	@Autowired
	FlightBookingServiceImpl fligthbookService;
	
	@Autowired
	LoginServicesImpl loginService;
	
	@Autowired
	CheckinServiceImpl checkinService;
	
	Logger logger = LoggerFactory.getLogger(TicketManagmentControllerImpl.class);
	
	/** Search flights according to the user input
	 * if no flights found it also prompts the user the same
	 */
	@PostMapping("/SearchFlights")
	public ModelAndView searchBookFlight(@ModelAttribute BookFlights flightService) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("search.jsp");
		if(loginService.activeUserId()==0)
		{
			mv.addObject("login","Please Login to book your tickets");
			logger.warn("Please Login to book your tickets");
			return mv;
		}
		else {
		List<Flights> searchedFlights=fligthbookService.searchFlights(flightService);
		if(searchedFlights.isEmpty()) {
			logger.warn("no flights found");
		}
		else
		
		mv.addObject("l",searchedFlights);
		return mv;
		
		}
	}
	
	BookedTickets c_ticket;
	
	/** Books flights according to the user input
	 * If not enough seats it also prompts the user the same
	 */
	@PostMapping("/BookFlights")
	public ModelAndView bookFlightTickets(@ModelAttribute BookedTickets ticket) {
		ModelAndView mv=new ModelAndView();
		ticket.setU(loginService.getActiveuser());
		c_ticket=ticket;
		mv.setViewName("search.jsp");
		if(loginService.activeUserId()==0)
		{
			mv.addObject("login","Please Login to book your tickets");
			logger.warn("Please Login to book your tickets");
			return mv;
		}
		else {
		String count=fligthbookService.checkTicketCount(ticket);
		mv.addObject("count",count);
		if(fligthbookService.calculateCost(c_ticket) && (count.equals("Booking Success")))
		{
			logger.info("Proceding to payment");
			return new ModelAndView("redirect:/displaypayment");			
		}
		else 
			return mv;
		}
		
	}
	
	/**Display the payment page 
	 */
	@PostMapping("/displaypayment")
	public ModelAndView displayPayment() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("payment.jsp");
		mv.addObject("totalcost",fligthbookService.getPrice());
		return mv;
	}
	
	/** Process all the payment related mappings
	 */
	@PostMapping("/payment")
	public ModelAndView Payment() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("payment.jsp");
		mv.addObject("totalcost",c_ticket.getPrice());
		String s=fligthbookService.bookFlightss(c_ticket);
		mv.addObject("count", s);
		if((s.equals("Booking Success"))) {
			logger.info("Tickets Booked");
			return new ModelAndView("redirect:/manage");
		}
		else {
			logger.warn("Tickets not Booked");
			return mv;
		}
	}
	
	
	
	
	

}
