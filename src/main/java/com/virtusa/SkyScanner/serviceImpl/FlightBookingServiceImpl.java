package com.virtusa.SkyScanner.serviceImpl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.SkyScanner.model.BookFlights;
import com.virtusa.SkyScanner.model.BookedTickets;
import com.virtusa.SkyScanner.model.Flights;
import com.virtusa.SkyScanner.model.Users;
import com.virtusa.SkyScanner.repository.BookTicketsRepository;
import com.virtusa.SkyScanner.repository.FligthsRepository;
import com.virtusa.SkyScanner.repository.UsersRepository;
import com.virtusa.SkyScanner.service.FlightBookingService;

/** 
 * This service implements FlightBookingService interface and handles all the processing for ticket booking related requests
  */
@Service
public class FlightBookingServiceImpl implements FlightBookingService{
	
	@Autowired
	FligthsRepository flightsRepo;
	
	
	@Autowired
	BookTicketsRepository bookticketRepo;
	
	@Autowired
	CheckinServiceImpl checinService;
	

	
	@Autowired
	UsersRepository userRepo;
	

	Flights f;
	double price=0;
	
	/** 
	 * This is to search flights
	  */
	public List<Flights> searchFlights(BookFlights f) {

		return  flightsRepo.search(f.getFrom(),f.getTo());
		
	}
	
	
	/** 
	 * This is to book flights
	  */
	public String bookFlightss(BookedTickets ticket) {
		f=flightsRepo.getFlight(ticket.getFlightnumber());
		if((checkTicketCount(ticket)).equals("Booking Success"))
		{
			updateTicketCount(ticket);
			bookticketRepo.save(ticket);
			ticket.setPaymentstatus("Paid");
			checinService.setSeats(ticket.getTid());
			return "Booking Success";
		}
		else
			return "Only "+f.getSeatcount()+" available";
	}
	
	/** 
	 * This is check the ticket count of a particular flight
	  */
	public String checkTicketCount(BookedTickets ticket) {
		f=flightsRepo.getFlight(ticket.getFlightnumber());
		if(f.getSeatcount()<(ticket.getAdultcount())+(ticket.getChildrencount()))
			return "Only "+f.getSeatcount()+" available";
		else 
			return "Booking Success";
	}
	
	/** 
	 * This is get update the ticket count
	  */
	public void updateTicketCount(BookedTickets ticket) {
		f=flightsRepo.getFlight(ticket.getFlightnumber());
		int count=(ticket.getAdultcount())+(ticket.getChildrencount());
		f.setSeatcount((f.getSeatcount())-count);
		flightsRepo.updateTicketCount(f.getflightnumber(),f.getSeatcount());
	}

	/** 
	 * This is to calculate the cost of the ticket based on the passenger count
	  */
	public boolean calculateCost(BookedTickets ticket) {
		price=0;
		f=flightsRepo.getFlight(ticket.getFlightnumber());
		double fprice=f.getPrice();
		if(ticket.getAdultcount()!=0)
			price+=(ticket.getAdultcount())*(fprice);
		if(ticket.getChildrencount()!=0)
			price+=(ticket.getChildrencount())*(fprice/2);
		ticket.setPrice(price);
		return true;
	}
	
	
	/** 
	 * This is get price
	  */
	public double getPrice() {
		return price;
	}

	/** 
	 * This is cancel ticket by id
	  */
	public String cancelTicket(int n) {
		bookticketRepo.deleteById(n);
		return "Cancelled";
	}
	
	/** 
	 * This is get details of ticket based on the user
	  */
	public List<BookedTickets> userTicketDisplay(int n) {
		return bookticketRepo.findByU(userRepo.findById(n).orElse(null));
	}

	/** 
	 * This is get details of flight based on flight number
	  */
	public List<BookedTickets> manageTicket(Users uss) {
		return bookticketRepo.findByU(uss);
	}
	
}