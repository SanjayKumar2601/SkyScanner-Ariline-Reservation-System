package com.virtusa.SkyScanner.serviceImpl;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import com.virtusa.SkyScanner.model.Flights;
import com.virtusa.SkyScanner.repository.FligthsRepository;
import com.virtusa.SkyScanner.service.FlightServices;



/** 
 * This service implements FlightService interface and handles all the processing for flight related requests
  */
@Primary
@Service
public class FlightServicesImpl implements FlightServices{
	
	@Autowired
	FligthsRepository flightsRepo;
	
	/** 
	 * This is to add flight
	  */
	public void addFlight(Flights flight) {
		flightsRepo.save(flight);
	}
	
	/** 
	 * This is to remove flight based on flight id
	  */
	public void removeFlightByFlightNumber(int flightid) {
		flightsRepo.deleteByFlightnumber(flightid);
		
	}

	/** 
	 * This is get details of all flights
	  */
	public List<Flights> getAllFlights() {
		return flightsRepo.findAll();
	}
	


	
	

	



}
