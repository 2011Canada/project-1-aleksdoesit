package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Credentials;
import com.revature.models.User;
import com.revature.services.UserService;

public class AuthController {
	
	private ObjectMapper om = new ObjectMapper();
	
	
	//implement or copy over userpostgresdao data from NTCBank or build new
	private UserService us = new UserServiceImplementation(new UserPostgresDAO());

	public void userLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		Credentials cred = om.readValue(req.getInputStream(), Credentials.class);
		
		
//		userService implementation still needed
		User u = us.login(cred.getUsername(), cred.getPassword());
		
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(u));
		
		
		
	}
	
}
