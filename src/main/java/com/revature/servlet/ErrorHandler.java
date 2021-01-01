package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.exceptions.AbstractHttpException;

public class ErrorHandler extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Throwable t = (Throwable) req.getAttribute("javax.servlet.error.exception");
		
		if(t == null) {
			
			resp.setStatus(500);
			resp.getWriter().write("Oops! Something went terribly wrong.");
			return;
			
		}
		
		if(t instanceof AbstractHttpException) {
			
			AbstractHttpException err = (AbstractHttpException) t;
			resp.setStatus(err.getStatusCode());
			resp.getWriter().write(err.getMessage());
			
		} else {
			
			t.printStackTrace();
			resp.setStatus(500);
			resp.getWriter().write("Oops! Something went terribly wrong.");
			
		}
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
