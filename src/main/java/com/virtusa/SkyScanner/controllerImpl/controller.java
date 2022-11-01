//package com.virtusa.SkyScanner.controllerImpl;
//
//
//
//import java.util.List;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//import com.virtusa.SkyScanner.model.BookFlights;
//import com.virtusa.SkyScanner.model.BookedTickets;
//import com.virtusa.SkyScanner.model.Flights;
//import com.virtusa.SkyScanner.model.Users;
//import com.virtusa.SkyScanner.serviceImpl.CheckinServiceImpl;
//import com.virtusa.SkyScanner.serviceImpl.FlightBookingServiceImpl;
//import com.virtusa.SkyScanner.serviceImpl.FlightServicesImpl;
//import com.virtusa.SkyScanner.serviceImpl.LoginServicesImpl;
//import com.virtusa.SkyScanner.serviceImpl.UserServiceImpl;
//
//
//@RestController
//public class controller {
//	
//	@Autowired
//	UserServiceImpl userService;
//	
//	@Autowired
//	FlightServicesImpl flightService;
//	
//	@Autowired
//	FlightBookingServiceImpl fligthbookService;
//	
//	@Autowired
//	LoginServicesImpl loginService;
//	
//	@Autowired
//	CheckinServiceImpl checkinService;
//	
//	Logger logger = LoggerFactory.getLogger(controller.class);
//	
//
//	@RequestMapping("/userlogin")
//	public ModelAndView getLogin(@RequestParam("email")String email,@RequestParam("password")String password) {
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("Signup.jsp");
//		String validationStatus=loginService.validateUser(email,password);
//		mv.addObject("validationStatus",validationStatus);
//		if(validationStatus.equals("Login successfull")) 
//		{
//		logger.info("Validation Status : "+validationStatus);
//		return new ModelAndView("redirect:/Home.jsp");
//		}
//		else
//			return mv;
//		
//	}
//	
//	@GetMapping("/Home")
//	public ModelAndView getHome() {
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("Home.jsp");
//		return mv;
//	}
//	
//	
//	@RequestMapping("/usersignup")
//	public ModelAndView getSignupDetails(@ModelAttribute Users user) {
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("Signup.jsp");
//		userService.addUsers(user);
//		logger.info("Sign Up Successful");
//		return mv;
//	}
//	@RequestMapping("/displaycheckin")
//	public ModelAndView displayCheckin() {
//		ModelAndView mv=new ModelAndView("checkin.jsp");
//		if(loginService.activeUserId()==0)
//		{
//			mv.addObject("login","Please Login to check in with your tickets");
//			return mv;
//		}
//		else {
//		List<BookedTickets> tickets=fligthbookService.userTicketDisplay(loginService.activeUserId());
//		mv.addObject("tickets",tickets);
//		return mv;
//		}
//	}
//	
//	int tId;
//	@RequestMapping("/checkin")
//	public ModelAndView getCheckinDetails(@RequestParam(name="tid") String tid) {
//		ModelAndView mv=new ModelAndView("checkin.jsp");
//		if(loginService.activeUserId()==0)
//		{
//			mv.addObject("login","Please Login to check in with your tickets");
//			return mv;
//		}
//		else {
//		List<BookedTickets> tickets=fligthbookService.userTicketDisplay(loginService.activeUserId());
//		mv.addObject("tickets",tickets);
//		tId=Integer.parseInt(tid);
//		if(checkinService.setSeats(tId))
//			return new ModelAndView("redirect:/seatmap.jsp");
//		else
//			return mv;
//		}
//	}
//	
//	@RequestMapping("/adminlogin")
//	public ModelAndView getAdminLoginDetails(@RequestParam("email")String email,@RequestParam("password")String password) {
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("admin_login.jsp");
//		String s=loginService.validateAdmin(email,password);
//		mv.addObject("validationStatus", s);
//		if(s.equals("Login successfull")) 
//		{
//		logger.info("Admin Validation Status : "+s);
//		return new ModelAndView("redirect:/adminhome.jsp");
//		}
//		else
//			return mv;
//		
//	}
//	
//	@RequestMapping("/addFlights")
//	public ModelAndView setFlightDetails(@ModelAttribute Flights flight) {
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("addFlights.jsp");
//		flightService.addFlight(flight);
//		logger.info("Fligth Added");
//		return mv;
//	}
//	
//
//	@RequestMapping("/SearchFlights")
//	public ModelAndView searchBookFlight(@ModelAttribute BookFlights flightService) {
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("search.jsp");
//		if(loginService.activeUserId()==0)
//		{
//			mv.addObject("login","Please Login to book your tickets");
//			logger.warn("Please Login to book your tickets");
//			return mv;
//		}
//		else {
//		List<Flights> searchedFlights=fligthbookService.searchFlights(flightService);
//		if(searchedFlights.isEmpty()) {
//			logger.warn("no flights found");
//		}
//		else
//		
//		mv.addObject("l",searchedFlights);
//		return mv;
//		
//		}
//	}
//	
//	BookedTickets c_ticket;
//	
//	@RequestMapping("/BookFlights")
//	public ModelAndView bookFlightTickets(@ModelAttribute BookedTickets ticket) {
//		ModelAndView mv=new ModelAndView();
//		ticket.setU(loginService.getActiveuser());
//		c_ticket=ticket;
//		mv.setViewName("search.jsp");
//		if(loginService.activeUserId()==0)
//		{
//			mv.addObject("login","Please Login to book your tickets");
//			logger.warn("Please Login to book your tickets");
//			return mv;
//		}
//		else {
//		String count=fligthbookService.checkTicketCount(ticket);
//		mv.addObject("count",count);
//		if(fligthbookService.calculateCost(c_ticket) && (count.equals("Booking Success")))
//		{
//			logger.info("Proceding to payment");
//			return new ModelAndView("redirect:/displaypayment");			
//		}
//		else 
//			return mv;
//		}
//		
//	}
//	
//	@RequestMapping("/adminHome")
//	public ModelAndView adminHome() {
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("adminhome.jsp");
//		return mv;
//	}
//	
//	
//	@RequestMapping("/displaycancelTicket")
//	public ModelAndView cancelTickets() {//@RequestParam("ticketid") int ticketid
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("cancel.jsp");
//		if(loginService.activeUserId()==0)
//		{
//			mv.addObject("login","Please Login to cancel your tickets");
//			logger.warn("Please Login to cancel your tickets");
//			return mv;
//		}
//		else {
//		List<BookedTickets> tickets=fligthbookService.userTicketDisplay(loginService.activeUserId());
//		mv.addObject("tickets",tickets);
//		return mv;
//		}
//	}
//	
//	@RequestMapping("/cancelTicket")
//	public ModelAndView cancelTicket(@RequestParam("ticketid") String tid) {
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("cancel.jsp");
//		if(loginService.activeUserId()==0)
//		{
//			mv.addObject("login","Please Login to cancel your tickets");
//			logger.warn("Please Login to cancel your tickets");
//			return mv;
//		}
//		else {
//		List<BookedTickets> tickets=fligthbookService.userTicketDisplay(loginService.activeUserId());
//		mv.addObject("tickets",tickets);
//		int ticketid=Integer.parseInt(tid);
//		String status=fligthbookService.cancelTicket(ticketid);
//		if(status.equals("Cancelled")) {
//			mv.addObject("status","Ticket Canceled");
//			logger.info("Ticket Canceled");
//			return new ModelAndView("redirect:/manage");
//		}
//		else {
//			mv.addObject("status","Error : Try again later");
//			logger.warn("failed");
//			return mv;
//		}
//		}
//	}
//	
//	@RequestMapping("/displayremoveFlights")
//	public ModelAndView adminRemoveFligths() {
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("removeFlight.jsp");
//		List<Flights> allflights=flightService.getAllFlights(); 
//		mv.addObject("flights",allflights);
//		return mv;
//	}
//	
//	@RequestMapping("/removeFlight")
//	public ModelAndView adminRemoveFlight(@RequestParam(name="f") String f) {//
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("removeFlight.jsp");
//		int n=Integer.parseInt(f);
//		flightService.removeFlightById(n);
//		logger.info("flight removed");
//		return mv;
//	}
//	
//	@RequestMapping("/viewusers")
//	public ModelAndView adminViewUsers() {
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("adminviewflights.jsp");
//		List<Users> allusers=userService.getAllUsers();
//		mv.addObject("allusers",allusers);
//		return mv;
//	}
//	
//	@RequestMapping("/adminviewflights")
//	public ModelAndView adminViewFligths() {
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("adminviewflights.jsp");
//		List<Flights> allflights=flightService.getAllFlights(); 
//		mv.addObject("flights",allflights);
//		return mv;
//	}
//	
//	@RequestMapping("/displaypayment")
//	public ModelAndView displayPayment() {
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("payment.jsp");
//		mv.addObject("totalcost",fligthbookService.getPrice());
//		return mv;
//	}
//	
//	@RequestMapping("/payment")
//	public ModelAndView Payment() {
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("payment.jsp");
//		mv.addObject("totalcost",c_ticket.getPrice());
//		String s=fligthbookService.bookFlightss(c_ticket);
//		mv.addObject("count", s);
//		if((s.equals("Booking Success"))) {
//			logger.info("Tickets Booked");
//			return new ModelAndView("redirect:/manage");
//		}
//		else {
//			logger.warn("Tickets not Booked");
//			return mv;
//		}
//	}
//	
//	
//	@RequestMapping("/manage")
//	public ModelAndView manage() {
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("manage.jsp");
//		if(loginService.activeUserId()==0)
//		{
//			mv.addObject("login","Please Login to manage your tickets");
//			logger.warn("Please Login to manage your tickets");
//			return mv;
//		}
//		else {
//		List<BookedTickets> tickets=fligthbookService.userTicketDisplay(loginService.activeUserId());
//		mv.addObject("tickets",tickets);
//		return mv;
//		}
//	}
//	
//	@RequestMapping("/seatmapping")
//	public ModelAndView setSeatMapping(@RequestParam(name="seats") String seats) {
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("seatmap.jsp");
//		if(checkinService.updateSeats(tId,seats))
//		{
//			logger.info("Check-in Completed");
//			return new ModelAndView("redirect:/manage");
//		}
//		else {
//			logger.warn("Check-in Incomplete");
//			return mv;
//		}
//	}
//	@RequestMapping("/logout")
//	public ModelAndView Logout() {
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("Home.jsp");
//		loginService.setActiveuser(null);
//		mv.addObject("logout","Logged Out");
//		logger.info("logged out");
//		return mv;
//	}
//}
