package com.virtusa.SkyScanner.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtusa.SkyScanner.model.BookFlights;
import com.virtusa.SkyScanner.model.BookedTickets;
import com.virtusa.SkyScanner.model.CheckIn;
import com.virtusa.SkyScanner.model.Flights;
import com.virtusa.SkyScanner.model.Users;
import com.virtusa.SkyScanner.repository.BookTicketsRepository;
import com.virtusa.SkyScanner.repository.CheckinRepository;
import com.virtusa.SkyScanner.repository.FligthsRepository;
import com.virtusa.SkyScanner.repository.UsersRepository;
import com.virtusa.SkyScanner.serviceImpl.CheckinServiceImpl;
import com.virtusa.SkyScanner.serviceImpl.FlightBookingServiceImpl;
import com.virtusa.SkyScanner.serviceImpl.FlightServicesImpl;
import com.virtusa.SkyScanner.serviceImpl.LoginServicesImpl;
import com.virtusa.SkyScanner.serviceImpl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc(addFilters = false)
public class ControllerTest {
	
	@MockBean
	UsersRepository userRepo;
	
	@MockBean
	FligthsRepository flightRepo;
	
	@MockBean
	BookTicketsRepository ticketRepo;
	
	@MockBean
	CheckinRepository checkinRepo;
	
	
	@Autowired
	LoginServicesImpl loginService;
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	FlightServicesImpl flightService;
	
	@Autowired
	FlightBookingServiceImpl flightbService;
	
	@Autowired
	CheckinServiceImpl checkService;
	
	@Autowired
	public MockMvc mockmvc;
	
	@Autowired
	public WebApplicationContext context;
	
	ObjectMapper om=new ObjectMapper();
	
	
	Users u=new Users(1,"mail","sa","sa");
	Flights fl=new Flights(1,1,"chennai","mumbai","09:00","10:00",100.00,100);
	BookFlights bf=new BookFlights(1,"round","chennai","mumbai","12-10-12",1,1);
	BookedTickets bt=new BookedTickets(1,1,2,4,"A3",u);
	BookedTickets tickets1=new BookedTickets(1,1,2,3,"B6",u);
	CheckIn c=new CheckIn(1,"Airport Check In");
	
	
	@Test
	void getLoginTest() throws Exception{
		Users u=new Users(1,"sachin","sachin@gmail.com","sa");
		mockmvc.perform(post("/userlogin").param("email", "sachin@gmail.com").param("password", "sa")).andExpect(view().name("Signup.jsp")).andReturn();
	}
	
	@Test
	void getHomeTest() throws Exception{
		mockmvc.perform(get("/Home")).andExpect(status().isOk()).andExpect(view().name("Home.jsp")).andReturn();
	}
	

	@Test
	void getSignupDetailsTest() throws Exception{
		mockmvc.perform(post("/usersignup")).andExpect(status().isOk()).andExpect(view().name("Signup.jsp")).andReturn();
	}
	
	@Test
	void displayCheckinTest() throws Exception{
		mockmvc.perform(post("/displaycheckin")).andExpect(status().isOk()).andExpect(view().name("checkin.jsp")).andReturn();
	}
	
	@Test
	void displayCheckinfailTest() throws Exception{
		loginService.setActiveuser(null);
		mockmvc.perform(post("/displaycheckin")).andExpect(status().isOk()).andExpect(view().name("checkin.jsp")).andReturn();
	}
	
	@Test
	void getCheckinDetailsTest() throws Exception{
		loginService.setActiveuser(u);
		mockmvc.perform(post("/checkin").param("tid", "1")).andExpect(view().name("redirect:/seatmap.jsp")).andReturn();
	}
	
	@Test
	void getCheckinDetailsfailTest() throws Exception{
		loginService.setActiveuser(null);
		mockmvc.perform(post("/checkin").param("tid", "1")).andExpect(view().name("checkin.jsp")).andReturn();
	}
	
	@Test
	void getAdminLoginDetailsTest() throws Exception{
		mockmvc.perform(post("/adminlogin").param("email", "admin@admin.com").param("password", "root")).andExpect(view().name("redirect:/adminhome.jsp")).andReturn();
	}
	
	@Test
	void getAdminLoginDetailsfailTest() throws Exception{
		mockmvc.perform(post("/adminlogin").param("email", "sachin@gmail.com").param("password", "root")).andExpect(view().name("admin_login.jsp")).andReturn();
	}
	
	
	@Test
	void setFlightDetailsTest() throws Exception{
		mockmvc.perform(post("/addFlights")).andExpect(status().isOk()).andExpect(view().name("addFlights.jsp")).andReturn();
	}
	
	@Test
	void searchBookFlightTest() throws Exception{
		loginService.setActiveuser(u);
		mockmvc.perform(post("/SearchFlights")).andExpect(status().isOk()).andExpect(view().name("search.jsp")).andReturn();
	}
	
	@Test
	void searchBookFlightfailTest() throws Exception{
		loginService.setActiveuser(null);
		mockmvc.perform(post("/SearchFlights")).andExpect(status().isOk()).andExpect(view().name("search.jsp")).andReturn();
	}
	
	@Test
	void bookFlightTicketsfailTest() throws Exception{
		loginService.setActiveuser(null);
		mockmvc.perform(post("/BookFlights")).andExpect(status().isOk()).andExpect(view().name("search.jsp")).andReturn();
	}
	
	@Test
	void adminHometTest() throws Exception{
		mockmvc.perform(post("/adminHome")).andExpect(status().isOk()).andExpect(view().name("adminhome.jsp")).andReturn();
	}
	
	@Test
	void cancelTicketsTest() throws Exception{
		loginService.setActiveuser(u);
		mockmvc.perform(post("/displaycancelTicket")).andExpect(status().isOk()).andExpect(view().name("cancel.jsp")).andReturn();
	}
	
	@Test
	void cancelTicketsfailTest() throws Exception{
		loginService.setActiveuser(null);
		mockmvc.perform(post("/displaycancelTicket")).andExpect(status().isOk()).andExpect(view().name("cancel.jsp")).andReturn();
	}
	
	@Test
	void cancelTicketTests() throws Exception{
		loginService.setActiveuser(u);
		mockmvc.perform(post("/cancelTicket").param("ticketid","1")).andExpect(view().name("redirect:/manage")).andReturn();
	}
	
	@Test
	void cancelTicketfailTests() throws Exception{
		loginService.setActiveuser(null);
		mockmvc.perform(post("/cancelTicket").param("ticketid","1")).andExpect(view().name("cancel.jsp")).andReturn();
	}
	
	@Test
	void adminRemoveFligthsTest() throws Exception{
		mockmvc.perform(post("/displayremoveFlights")).andExpect(status().isOk()).andExpect(view().name("removeFlight.jsp")).andReturn();
	}
	
	@Test
	void adminRemoveFlightTest() throws Exception{
		mockmvc.perform(post("/removeFlight").param("f", "1")).andExpect(status().isOk()).andExpect(view().name("removeFlight.jsp")).andReturn();
	}
	
	@Test
	void adminViewUsersTest() throws Exception{
		mockmvc.perform(post("/viewusers")).andExpect(status().isOk()).andExpect(view().name("adminviewflights.jsp")).andReturn();
	}
	
	@Test
	void adminViewFligthsTest() throws Exception{
		mockmvc.perform(post("/adminviewflights")).andExpect(status().isOk()).andExpect(view().name("adminviewflights.jsp")).andReturn();
	}
	
	@Test
	void displayPaymentTest() throws Exception{
		mockmvc.perform(post("/displaypayment")).andExpect(status().isOk()).andExpect(view().name("payment.jsp")).andReturn();
	}
	
	@Test
	void manageTest() throws Exception{
		loginService.setActiveuser(u);
		mockmvc.perform(post("/manage")).andExpect(status().isOk()).andExpect(view().name("manage.jsp")).andReturn();
	}
	
	@Test
	void managefailTest() throws Exception{
		loginService.setActiveuser(null);
		mockmvc.perform(post("/manage")).andExpect(status().isOk()).andExpect(view().name("manage.jsp")).andReturn();
	}
	
	@Test
	void setSeatMappingTest() throws Exception{
		loginService.setActiveuser(u);
		mockmvc.perform(post("/checkin").param("tid", "1")).andExpect(view().name("redirect:/seatmap.jsp")).andReturn();
		mockmvc.perform(post("/seatmapping").param("seats", "A1")).andExpect(view().name("redirect:/manage")).andReturn();
	}
	
	@Test
	void LogoutTest() throws Exception{
		mockmvc.perform(post("/logout")).andExpect(status().isOk()).andExpect(view().name("Home.jsp")).andReturn();
	}
	
	
	
	
}
