package com.virtusa.SkyScanner.controllerImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//import com.virtusa.SkyScanner.controller.UserController;
import com.virtusa.SkyScanner.model.BookedTickets;
import com.virtusa.SkyScanner.model.Users;
import com.virtusa.SkyScanner.serviceImpl.CheckinServiceImpl;
import com.virtusa.SkyScanner.serviceImpl.FlightBookingServiceImpl;
import com.virtusa.SkyScanner.serviceImpl.FlightServicesImpl;
import com.virtusa.SkyScanner.serviceImpl.LoginServicesImpl;
import com.virtusa.SkyScanner.serviceImpl.UserServiceImpl;

/** Handles all the user releated mappings
 */
@RestController
public class UserControllerImpl{
	
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
	
	Logger logger = LoggerFactory.getLogger(UserControllerImpl.class);
	
	/** Receives all the login details from the user and validates them by also prompting the user
	 */
	@PostMapping("/userlogin")
	public ModelAndView getLogin(@RequestParam("email")String email,@RequestParam("password")String password) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Signup.jsp");
		String validationStatus=loginService.validateUser(email,password);
		mv.addObject("validationStatus",validationStatus);
		if(validationStatus.equals("Login successfull")) 
		{
		logger.info("Validation Status : "+validationStatus);
		return new ModelAndView("redirect:/Home.jsp");
		}
		else
			return mv;
		
	}
	
	/** Displays home page of the application
	 */
	@GetMapping("/Home")
	public ModelAndView getHome() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Home.jsp");
		return mv;
	}
	
	/** Receives all the user details from the user and registers as a new user
	 */
	@PostMapping("/usersignup")
	public ModelAndView getSignupDetails(@ModelAttribute Users user) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Signup.jsp");
		userService.addUsers(user);
		logger.info("Sign Up Successful");
		return mv;
	}
	
	/** Displays check in page
	 */
	@PostMapping("/displaycheckin")
	public ModelAndView displayCheckin() {
		ModelAndView mv=new ModelAndView("checkin.jsp");
		if(loginService.activeUserId()==0)
		{
			mv.addObject("login","Please Login to check in with your tickets");
			return mv;
		}
		else {
		List<BookedTickets> tickets=fligthbookService.userTicketDisplay(loginService.activeUserId());
		mv.addObject("tickets",tickets);
		return mv;
		}
	}
	
	
	int tId;
	/** Handles the process of check - in
	 */
	@PostMapping("/checkin")
	public ModelAndView getCheckinDetails(@RequestParam(name="tid") String tid) {
		ModelAndView mv=new ModelAndView("checkin.jsp");
		if(loginService.activeUserId()==0)
		{
			mv.addObject("login","Please Login to check in with your tickets");
			return mv;
		}
		else {
		List<BookedTickets> tickets=fligthbookService.userTicketDisplay(loginService.activeUserId());
		mv.addObject("tickets",tickets);
		tId=Integer.parseInt(tid);
		if(checkinService.setSeats(tId))
			return new ModelAndView("redirect:/seatmap.jsp");
		else
			return mv;
		}
	}
	
	/** Displays cancel ticket page
	 */
	@PostMapping("/displaycancelTicket")
	public ModelAndView cancelTickets() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("cancel.jsp");
		if(loginService.activeUserId()==0)
		{
			mv.addObject("login","Please Login to cancel your tickets");
			logger.warn("Please Login to cancel your tickets");
			return mv;
		}
		else {
		List<BookedTickets> tickets=fligthbookService.userTicketDisplay(loginService.activeUserId());
		mv.addObject("tickets",tickets);
		return mv;
		}
	}
	
	/** Cancel the booked tickets by ticket id
	 */
	@PostMapping("/cancelTicket")
	public ModelAndView cancelTicket(@RequestParam("ticketid") String tid) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("cancel.jsp");
		if(loginService.activeUserId()==0)
		{
			mv.addObject("login","Please Login to cancel your tickets");
			logger.warn("Please Login to cancel your tickets");
			return mv;
		}
		else {
		List<BookedTickets> tickets=fligthbookService.userTicketDisplay(loginService.activeUserId());
		mv.addObject("tickets",tickets);
		int ticketid=Integer.parseInt(tid);
		String status=fligthbookService.cancelTicket(ticketid);
		if(status.equals("Cancelled")) {
			mv.addObject("status","Ticket Canceled");
			logger.info("Ticket Canceled");
			return new ModelAndView("redirect:/manage");
		}
		else {
			mv.addObject("status","Error : Try again later");
			logger.warn("failed");
			return mv;
		}
		}
	}
	
	/** Displays all the booked tickets and its details
	 */
	@PostMapping("/manage")
	public ModelAndView manage() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("manage.jsp");
		if(loginService.activeUserId()==0)
		{
			mv.addObject("login","Please Login to manage your tickets");
			logger.warn("Please Login to manage your tickets");
			return mv;
		}
		else {
		List<BookedTickets> tickets=fligthbookService.userTicketDisplay(loginService.activeUserId());
		mv.addObject("tickets",tickets);
		return mv;
		}
	}
	
	
	/**Provides the seat mapping of the flight and register the seats checked in for the respective ticket
	 */
	@PostMapping("/seatmapping")
	public ModelAndView setSeatMapping(@RequestParam(name="seats") String seats) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("seatmap.jsp");
		if(checkinService.updateSeats(tId,seats))
		{
			logger.info("Check-in Completed");
			return new ModelAndView("redirect:/manage");
		}
		else {
			logger.warn("Check-in Incomplete");
			return mv;
		}
	}
	
	/** Logout for both user and admin this redirects back to the home page on successful logout
	 */
	@PostMapping("/logout")
	public ModelAndView Logout() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Home.jsp");
		loginService.setActiveuser(null);
		mv.addObject("logout","Logged Out");
		logger.info("logged out");
		return mv;
	}
}
