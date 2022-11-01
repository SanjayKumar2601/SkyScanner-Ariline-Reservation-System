package com.virtusa.SkyScanner.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtusa.SkyScanner.model.Users;
import com.virtusa.SkyScanner.service.LoginServices;

/** 
 * This service implements loginServices interface and handles all the processing for login related requests for both admin and user
  */
@Service
public class LoginServicesImpl implements LoginServices {
	
	@Autowired
	UserServiceImpl userSer;
	Logger logger = LoggerFactory.getLogger(LoginServicesImpl.class);

	String username;
	String pass;
	int id;
	Users activeuser;
	
	/** 
	 * This is validate login details based on mail and password and returns the validation status with setting the active user
	  */
	public String validateUser(String mail,String pass) {

		Users user=userSer.validateUserName(mail);
		if(user==null)
			return "Invalid Creditials";
		else
		{
			if(user.getEmail().equals(mail)&&user.getPassword().equals(pass))
			{
				activeuser=user;
				return "Login successfull";				
			}
			else
				return "Invalid Creditials";
		}
	}
	
	/** 
	 * This is get active user object
	  */
	public Users getActiveuser() {
		return activeuser;
	}
	/** 
	 * This is set active user object
	  */
	public void setActiveuser(Users currentActiveUser) {
		this.activeuser=currentActiveUser;
	}
	/** 
	 * This is get active user id,if active user null the returns 0
	  */
	public int activeUserId() {
		if(activeuser==null)
			return 0;
		else
			return activeuser.getId();
	}

	/** 
	 * This is validate admin login details
	  */
	public String validateAdmin(String email, String password) {
		if(email.equals("admin@admin.com")&&password.equals("root"))
			return "Login successfull";
		else
			return "Invalid Creditials";
		
	}
	
	
}
