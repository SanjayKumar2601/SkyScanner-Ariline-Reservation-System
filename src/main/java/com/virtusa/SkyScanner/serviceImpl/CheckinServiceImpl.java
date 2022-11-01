package com.virtusa.SkyScanner.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtusa.SkyScanner.model.CheckIn;
import com.virtusa.SkyScanner.repository.BookTicketsRepository;
import com.virtusa.SkyScanner.repository.CheckinRepository;
import com.virtusa.SkyScanner.service.CheckinService;
/** 
 * This service implements CheckinService interface and handles all the processing for check in related requests
  */
@Service
public class CheckinServiceImpl implements CheckinService{
	
	@Autowired
	CheckinRepository checkinRepo;
	
	@Autowired
	BookTicketsRepository bookedTickRepo;
	
	Logger logger = LoggerFactory.getLogger(CheckinServiceImpl.class);
	
	CheckIn checkin=new CheckIn();
	
	/** 
	 * This is set details of the seats while checking in
	  */
	public boolean setSeats(int tid) {
		checkin.setTicketId(tid);
		checkin.setSeats("Airport Check In");
		checkinRepo.save(checkin);
		logger.info("Checkin Status :Airport Check In");
		return true;
		
	}

	/** 
	 * This is update seat details while checking in
	  */
	public boolean updateSeats(int tid,String seats) {
		checkinRepo.updateSeats(tid,seats);
		bookedTickRepo.updateSeats(tid,seats);
		return true;
	}
	
}
