package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.AuthController;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	
	private AuthController authController = new AuthController();
    
	protected void directControl(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		String URI = req.getRequestURI().substring(req.getContextPath().length(),
													req.getRequestURI().length());
		
		switch(URI) {
		
		case "/login" : {
			
			switch (req.getMethod()) {
				case "GET": {
					
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				
				}
				
				case "POST": {
					
					authController.userLogin(req, res);
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
