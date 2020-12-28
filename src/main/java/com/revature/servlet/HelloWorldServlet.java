package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("This is a GET method on the path: " + req.getContextPath());
		
		
		//getWriter is a writer object on the response object, is used to write to the body of the response
		resp.getWriter().write(
				
				"<h1>Hello World!</h1>"
				
				);
	}
	
}
