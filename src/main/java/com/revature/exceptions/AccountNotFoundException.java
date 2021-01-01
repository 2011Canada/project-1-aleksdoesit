package com.revature.exceptions;

public class AccountNotFoundException extends AbstractHttpException {
	public AccountNotFoundException() {
		super("The account you entered could not found", 404);
	}
}
