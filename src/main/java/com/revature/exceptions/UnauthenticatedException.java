package com.revature.exceptions;

public class UnauthenticatedException extends AbstractHttpException {

	public UnauthenticatedException() {
		
		super("Please login before making any requests.", 401);
		
	}

	
	
}
