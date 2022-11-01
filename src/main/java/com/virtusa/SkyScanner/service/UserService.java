package com.virtusa.SkyScanner.service;

import java.util.List;

import com.virtusa.SkyScanner.model.Users;
/** This interface is for user Services
 * */
public interface UserService {

	public void addUsers(Users user);
	public Users validateUserName(String mail);
	public List<Users> getAllUsers();
}
