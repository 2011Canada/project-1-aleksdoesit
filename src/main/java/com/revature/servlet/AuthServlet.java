package com.revature.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Credentials;
import com.revature.models.User;
import com.sun.tools.javac.util.List;

public class AuthServlet extends HttpServlet {
	
	static ArrayList<User> allUsers = new ArrayList<User>();
	
	static {
		
		allUsers.add(new User("Aleks", "password", "Aleks Nikolic", 1));
		allUsers.add(new User("Bruce", "password", "Bruce Wayne", 2));
		
	}
	
	ObjectMapper om = new ObjectMapper();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Credentials cred = om.readValue(req.getInputStream(), Credentials.class);
		
		System.out.println(cred);
		
		boolean found = false;
		
		for(User u : allUsers) {
			
			if(cred.getUsername().equals(u.getUsername()) && cred.getPassword().equals(u.getPassword())) {
				
				resp.setStatus(200);
				resp.getWriter().write(om.writeValueAsString(u));
				resp.setHeader("Content-Type", "application/json");
				found = true;
				break;
				
			}
			
		}
		
		if (!found) {
			
			resp.setStatus(401);
			resp.getWriter().write("Username or password not found or incorrect.");
		}
		
		
	}
	
}
