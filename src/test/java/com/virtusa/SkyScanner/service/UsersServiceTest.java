package com.virtusa.SkyScanner.service;

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
public class UsersServiceTest {

	
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
	
	
	@Test
	void getUsersTest() {
		when(userRepo.findAll()).thenReturn(Stream.of(new Users(1,"mail","sa","sa"),new Users(2,"mail2","dfs","dfs")).collect(Collectors.toList()));
		assertEquals(2,userServiceImpl.getAllUsers().size());
	}
	
	@Test
	void validateUserNameTest() {
		
		when(userRepo.findByEmail("mail")).thenReturn(u);
		assertEquals(u,userServiceImpl.validateUserName("mail"));
	}
	
	@Test
	void addUserTest() {
		userServiceImpl.addUsers(u);
//		assertEquals(1,userServiceImpl.getAllUsers().size());
		verify(userRepo,times(1)).save(u);
	}
	
	
}
