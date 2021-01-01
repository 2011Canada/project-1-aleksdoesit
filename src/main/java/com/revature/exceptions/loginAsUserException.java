package com.revature.exceptions;

public class loginAsUserException extends AbstractHttpException {

	public loginAsUserException() {
		
		super("Please login as a user to use this feature", 403);

	}

}
