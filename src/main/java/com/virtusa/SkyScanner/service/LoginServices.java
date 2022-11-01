package com.virtusa.SkyScanner.service;

import com.virtusa.SkyScanner.model.Users;

/** This interface is for login Services
 * */
public interface LoginServices {
	
	public String validateUser(String mail,String pass);
	public Users getActiveuser();
	public void setActiveuser(Users currentActiveUser);
	public int activeUserId();
	public String validateAdmin(String email, String password);
}
