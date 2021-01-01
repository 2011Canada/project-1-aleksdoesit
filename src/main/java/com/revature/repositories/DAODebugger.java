package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.InternalErrorException;
import com.revature.models.User;


public class DAODebugger {

	public static void main(String[] args) throws AccountNotFoundException, InternalErrorException {

		UserDAO ud = new UserPostgresDAO();
		
//		List<Customer> accounts = cl.printAllAccounts();
		
		
		System.out.println(ud.findUserByAccountnameAndPassword("georgie", "password"));
		System.out.println(ud.findAll());
		
	}
}
