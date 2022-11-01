package com.virtusa.SkyScanner.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.virtusa.SkyScanner.model.BookedTickets;
import com.virtusa.SkyScanner.model.Flights;
import com.virtusa.SkyScanner.model.Users;

/** This is the Booked tickets repository
 * */
public interface BookTicketsRepository extends JpaRepository<BookedTickets,Integer>{
	

/** This is to search flights according to user request
 * */
	@Query(value="select * from flights where departure=?1",nativeQuery=true)
	List<Flights> search(String from, String to);

	/** 
	 * This is to find booked tickets based on user
	  */
	List<BookedTickets> findByU(Users uss);

	/** 
	 * This is to update check-in details for the booked tickets
	  */
	@Transactional
	@Modifying
	@Query(value="UPDATE booked_tickets SET seats = ?2 WHERE tid = ?1",nativeQuery=true)
	void updateSeats(int tid, String seats);
	
	
	
	
}

	
	
	
	

	

