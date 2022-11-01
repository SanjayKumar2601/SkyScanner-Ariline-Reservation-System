package com.virtusa.SkyScanner.modelTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

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
@SpringBootTest
@AutoConfigureMockMvc
public class FlightsTest {

	
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
	private MockMvc mockmvc;
	
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
	void FlightsTest() {
		Flights fl=new Flights(1,1,"chennai","mumbai","09:00","10:00",100.00,100);
		Flights f=new Flights();
		f.setDeparture("chn");
		f.setDestination("mumbai");
		f.setendtime("10:00");
		f.setflightnumber(1);
		f.setPrice(100.00);
		f.setstarttime("06:00");
		assertEquals("chn",f.getDeparture());
		assertEquals("mumbai",f.getDestination());
		assertEquals("10:00",f.getendtime());
		assertEquals(1,f.getflightnumber());
		assertEquals(100.00,f.getPrice(),0);
		assertEquals("09:00",fl.getstarttime());
		}
	
	
}
