package com.virtusa.SkyScanner.service;

import java.util.List;

import com.virtusa.SkyScanner.model.Flights;

/** This interface is for flight Services
 * */
public interface FlightServices {

	public void addFlight(Flights flight);
//	public void removeFlightById(int flightid);
	public List<Flights> getAllFlights();
}
