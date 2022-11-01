package com.virtusa.SkyScanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.virtusa.SkyScanner.model.Users;

/** 
 * This is user repository
  */
public interface UsersRepository extends JpaRepository<Users,Integer>{

	/** 
	 * This is to get user details based on the email
	  */
	@Query(value="select * from Users where email=?1",nativeQuery=true)
	Users findByEmail(String mail);

	
	
}
