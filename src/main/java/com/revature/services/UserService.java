package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface UserService {

	public User login(String username, String password);
	
	public List<User> getAllUsers();
	
	public List<User> getAllReimbursements();
	
	public void requestReimbursement(double amount, String description, int userId);
	
	public void approveReimbursement(int reimbursementId);
	
	public void rejectReimbursement(int reimbursementId);
	
	public List<Reimbursement> requestUserHistory(int userId);
	
	public List<Reimbursement> requestSelfHistory(int userId);
	
}
