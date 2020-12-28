package com.revature.services;

import com.revature.models.User;

public interface UserService {

	public User login(String username, String password);
	
}
