package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repositories.UserDAO;

public class UserServiceImplementation implements UserService {
	
	
	//implement or copy UserDao from NTCBank
	private UserDAO ud;
	
	
	public UserServiceImplementation(UserDAO ud) {
		
		this.ud = ud;
		
	}
	

	@Override
	public User login(String username, String password) {
		
			
			User u = ud.findUserByAccountnameAndPassword(username, password);
			return u;
			
	}


	@Override
	public List<User> getAllUsers() {

		return ud.findAll();
		
	}


	@Override
	public List<User> getAllReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void requestReimbursement(double amount, String description, int userId) {
		
		ud.addReimbursement(amount, description, userId);
		
	}


	@Override
	public User approveReimbursement(int reimbursementId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User requestUserHistory(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
