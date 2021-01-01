package com.revature.exceptions;

public class UnauthorizedException extends AbstractHttpException {

	public UnauthorizedException() {
		
		super("Insufficient permissions, admin required.", 403);

	}

}
