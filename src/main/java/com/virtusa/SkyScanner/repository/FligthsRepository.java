package com.virtusa.SkyScanner.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.virtusa.SkyScanner.model.Flights;

/** 
 * This is flights repository
  */
public interface FligthsRepository extends JpaRepository<Flights,Integer>{

	/** 
	 * This is to search flights based on user reference
	  */
	@Query(value="select * from flights where departure=?1 && destination=?2",nativeQuery=true)
	List<Flights> search(String from, String to);
	
	/** 
	 * This is get details of flight based on flight number
	  */
	@Query(value="select * from flights where flightnumber=?1",nativeQuery=true)
	Flights getFlight(int fid);
	
	/** 
	 * This is update the seat count based on tickets booked
	  */
	@Transactional
	@Modifying
	@Query(value="UPDATE flights SET seatcount = ?2 WHERE id=?1",nativeQuery=true)
	void updateTicketCount(int flightnumber,int ticketcount);

	@Transactional
	@Modifying
	@Query(value="delete from flights where flightnumber=?1",nativeQuery=true)
	void deleteByFlightnumber(int flightid);

	
	

	
}
