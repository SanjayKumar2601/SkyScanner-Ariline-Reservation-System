package com.virtusa.SkyScanner.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.SkyScanner.model.Users;
import com.virtusa.SkyScanner.repository.UsersRepository;
import com.virtusa.SkyScanner.service.UserService;

/** 
 * This service implements UserService interface and handles all the processing for user date related requests
  */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UsersRepository userRepo;
	
	/** 
	 * This is to add new user
	  */
	public void addUsers(Users user) {
		userRepo.save(user);
		
	}

	/** 
	 * This is to find user based on email
	  */
	public Users validateUserName(String mail) {
		return userRepo.findByEmail(mail);
		
	}


	/** 
	 * This is get all users details
	  */
	public List<Users> getAllUsers() {
		return userRepo.findAll();
	}



	

}
