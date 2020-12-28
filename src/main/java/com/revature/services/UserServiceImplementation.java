package com.revature.services;

import com.revature.models.User;

public class UserServiceImplementation implements UserService {
	
	
	//implement or copy UserDao from NTCBank
	private UserDao ud;
	
	
	public UserServiceImplementation(UserDao ud) {
		
		this.ud = ud;
		
	}
	

	@Override
	public User login(String username, String password) {
		
		User u = ud.findUserByUsernameAndPassword(username, password);
		
		return u;
	}
	

	
}
