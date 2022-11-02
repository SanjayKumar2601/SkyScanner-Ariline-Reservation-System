package com.virtusa.SkyScanner.modelTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
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
@AutoConfigureMockMvc(addFilters = false)
public class CheckInTest {

	
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
	
	
	
	@Test
	void CheckInTest() {
		CheckIn c1=new CheckIn(1,"A6");
		CheckIn c=new CheckIn();
		
		c.setSeats("Q4");
		c.setTicketId(1);
		assertEquals("A6",c1.getSeats());
		assertEquals(1,c.getTicketId());
		
		}
	
	
}
