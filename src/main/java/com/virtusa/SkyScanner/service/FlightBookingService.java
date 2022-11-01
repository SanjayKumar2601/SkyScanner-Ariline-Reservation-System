package com.virtusa.SkyScanner.service;

import java.util.List;

import com.virtusa.SkyScanner.model.BookFlights;
import com.virtusa.SkyScanner.model.BookedTickets;
import com.virtusa.SkyScanner.model.Flights;
import com.virtusa.SkyScanner.model.Users;
/** This interface is for Flight booking Services
 * */
public interface FlightBookingService {
	
	public List<Flights> searchFlights(BookFlights f);
	public String bookFlightss(BookedTickets ticket) ;
	public String checkTicketCount(BookedTickets ticket);
	public void updateTicketCount(BookedTickets ticket);
	public boolean calculateCost(BookedTickets ticket);
	public double getPrice() ;
	public String cancelTicket(int n);
	public List<BookedTickets> userTicketDisplay(int n);
	public List<BookedTickets> manageTicket(Users uss);
}
