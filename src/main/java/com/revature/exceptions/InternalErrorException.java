package com.revature.exceptions;

public class InternalErrorException extends AbstractHttpException {
	public InternalErrorException() {
		super("You dun' broke something!", 500);
	}
}
