package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.ErrorController;
import com.revature.controllers.UserController;

public class UserLoggedInController extends HttpServlet {

	private ErrorController errorController = new ErrorController();
	private UserController userController = new UserController();

	protected void directControlRouter(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		String URI = req.getRequestURI().substring(req.getContextPath().length(),
														req.getRequestURI().length());

		switch(URI) {
		
			case "/userLogin" : {
			
				switch (req.getMethod()) {
					case "GET": {
				
//						userController.requestSelfHistory(req, res);
						userController.findAllUsers(req, res);
						break;
			
					}
			
					case "POST": {
						
						userController.requestReimbursement(req, res);
						break;
			
					}
			
					case "PUT": {
				
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
				
					}
			
					case "DELETE": {
				
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
			
					}
			
					default: {
			
						break;
				
					}
				}
				
			break;
			
			}
			
			default: {
				
				res.setStatus(404);
				res.getWriter().write("Cannot Find Requested Resource");
				break;			
			
			}
		}
	}
	
protected void directControl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		try {
			
			directControlRouter(request, response);
			
		} catch (Throwable t) {
			
			errorController.handle(request, response, t);
			
		}
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		directControl(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		directControl(request, response);
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		directControl(request, response);
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		directControl(request, response);
		
	}
}
