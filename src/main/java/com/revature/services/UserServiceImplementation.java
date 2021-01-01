package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.UserDAO;

public class UserServiceImplementation implements UserService {
	
	
	//implement or copy UserDao from NTCBank
	private UserDAO ud;
	
	
	public UserServiceImplementation(UserDAO ud) {
		
		this.ud = ud;
		
	}
	

	@Override
	public User login(String username, String password) {
		
			
			User u = ud.findUserByAccountnameAndPassword(username, password);
			return u;
			
	}
	

	
}
