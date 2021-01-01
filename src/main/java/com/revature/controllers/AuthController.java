package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Credentials;
import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.repositories.UserPostgresDAO;
import com.revature.services.UserService;
import com.revature.services.UserServiceImplementation;

public class AuthController {
	
	private ObjectMapper om = new ObjectMapper();
	
	private UserService us = new UserServiceImplementation(new UserPostgresDAO());

	public void userLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		Credentials cred = om.readValue(req.getInputStream(), Credentials.class);
		
		User u = us.login(cred.getUsername(), cred.getPassword());
		
		HttpSession sess = req.getSession();
		sess.setAttribute("User-Role", u.getUserRole());
		sess.setAttribute("User-Id", u.getUserId());
		sess.setAttribute("User-Name", u.getName());
		
		System.out.println(u.getUserRole());
		
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(u));
		
		System.out.println((Integer)sess.getAttribute("User-Id"));
		System.out.println(u);
		
	}
	
}
