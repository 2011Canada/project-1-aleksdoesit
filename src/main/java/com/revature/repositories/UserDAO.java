package com.revature.repositories;

import java.util.List;

import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.InternalErrorException;
import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface UserDAO {
	
	public User findUserByAccountnameAndPassword(String account_name, String password) throws AccountNotFoundException, InternalErrorException;
	
	public List<User> findAll();

	public void addReimbursement(double amount, String purpose, int userId);

	public void approveReimbursement(int reimbursementId);
	
	public void rejectReimbursement(int reimbursementId);
	
	public List<Reimbursement> printEmployeeRecords(int userId);
}