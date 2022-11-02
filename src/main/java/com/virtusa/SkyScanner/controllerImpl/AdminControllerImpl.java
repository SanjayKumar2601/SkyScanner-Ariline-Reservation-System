package com.virtusa.SkyScanner.controllerImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
//import com.virtusa.SkyScanner.controller.AdminController;
import com.virtusa.SkyScanner.model.Flights;
import com.virtusa.SkyScanner.model.Users;
import com.virtusa.SkyScanner.serviceImpl.CheckinServiceImpl;
import com.virtusa.SkyScanner.serviceImpl.FlightBookingServiceImpl;
import com.virtusa.SkyScanner.serviceImpl.FlightServicesImpl;
import com.virtusa.SkyScanner.serviceImpl.LoginServicesImpl;
import com.virtusa.SkyScanner.serviceImpl.UserServiceImpl;

/** This interface is for admin controller implementation.
 * Handles all the admin releated mappings
 * All implemented  */
@RestController
public class AdminControllerImpl{
	
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
	
	Logger logger = LoggerFactory.getLogger(AdminControllerImpl.class);
	
	/** Receives all login details and validates them.The validation status is returned to the web page the user is promted
	  */
	@PostMapping("/adminlogin")
	public ModelAndView getAdminLoginDetails(@RequestParam("email")String email,@RequestParam("password")String password) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("admin_login.jsp");
		String s=loginService.validateAdmin(email,password);
		mv.addObject("validationStatus", s);
		if(s.equals("Login successfull")) 
		{
		logger.info("Admin Validation Status : "+s);
		return new ModelAndView("redirect:/adminhome.jsp");
		}
		else
			return mv;
		
	}
	
	/** Adds new flights and is only accessible to admin
	 */
	@PostMapping("/addFlights")
	public ModelAndView setFlightDetails(@ModelAttribute Flights flight) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("addFlights.jsp");
		flightService.addFlight(flight);
		logger.info("Fligth Added");
		return mv;
	}
	
	/** Admin Home page to navigate through the requirements
	 */
	@PostMapping("/adminHome")
	public ModelAndView adminHome() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("adminhome.jsp");
		return mv;
	}
	
	/**Display the page for removing flights
	 */
	@PostMapping("/displayremoveFlights")
	public ModelAndView adminRemoveFligths() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("removeFlight.jsp");
		List<Flights> allflights=flightService.getAllFlights(); 
		mv.addObject("flights",allflights);
		return mv;
	}
	
	/** Removes flights and is only accessible to admin
	 */
	@PostMapping("/removeFlight")
	public ModelAndView adminRemoveFlight(@RequestParam(name="f") String f) {//
		ModelAndView mv=new ModelAndView();
		mv.setViewName("removeFlight.jsp");
		int n=Integer.parseInt(f);
		flightService.removeFlightByFlightNumber(n);
		logger.info("flight removed");
		return mv;
	}
	
	/** View all registered users and is only accessible to admin
	 */
	@PostMapping("/viewusers")
	public ModelAndView adminViewUsers() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("adminviewflights.jsp");
		List<Users> allusers=userService.getAllUsers();
		mv.addObject("allusers",allusers);
		return mv;
	}
	
	/** View all flights and is only accessible to admin
	 */
	@PostMapping("/adminviewflights")
	public ModelAndView adminViewFligths() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("adminviewflights.jsp");
		List<Flights> allflights=flightService.getAllFlights(); 
		mv.addObject("flights",allflights);
		return mv;
	}
	
	
	
	
}
