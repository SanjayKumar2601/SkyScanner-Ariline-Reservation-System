package com.virtusa.SkyScanner.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.virtusa.SkyScanner.model.CheckIn;

/** 
 * This is the check-in repository
  */
public interface CheckinRepository extends JpaRepository<CheckIn,Integer> {
	
	/** 
	 * This is to update seat details based on ticket id
	  */
	@Transactional
	@Modifying
	@Query(value="UPDATE check_in SET seats = ?2 WHERE ticket_id = ?1",nativeQuery=true)
	void updateSeats(int tid, String seats);

}
