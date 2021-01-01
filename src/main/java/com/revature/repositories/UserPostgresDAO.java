package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.InternalErrorException;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UserPostgresDAO implements UserDAO {

	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	Scanner userIn = new Scanner(System.in);

	public User findUserByAccountnameAndPassword(String account_name, String password)
			throws AccountNotFoundException, InternalErrorException {

		Connection conn = cf.getConnection();

		try {

			String sql = "select * from users where \"username\" = ? and \"password\" = ? ;";
			PreparedStatement getCustomer = conn.prepareStatement(sql);
			getCustomer.setString(1, account_name);
			getCustomer.setString(2, password);

			ResultSet res = getCustomer.executeQuery();
			if (res.next()) {

				User u = new User();

				u.setUserRole(res.getString("User-Role"));
				u.setName(res.getString("name"));
				u.setUsername(res.getString("username"));
				u.setPassword(res.getString("password"));
				u.setUserId(res.getInt("user_id"));

				return u;

			} else {

				throw new AccountNotFoundException();

			}

		} catch (SQLException e) {

			e.printStackTrace();
			throw new InternalErrorException();

		} finally {

			cf.releaseConnection(conn);

		}
	}

	public List<User> findAll() {

		Connection conn = this.cf.getConnection();
		List<User> allUsers = new ArrayList<User>();

		try {

			String sql = "select * from users";
			Statement s = conn.createStatement();

			ResultSet res = s.executeQuery(sql);

			while (res.next()) {

				User u = new User();

				u.setName(res.getString("name"));
				u.setUsername(res.getString("username"));
				u.setPassword(res.getString("password"));

				allUsers.add(u);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			cf.releaseConnection(conn);

		}

		return allUsers;

	}
	

	public void addReimbursement(double amount, String purpose, int userId) {
		
		Connection conn = cf.getConnection();
		
		try {
			
			String sql = "insert into reimbursements(\"description\", \"amount\", \"user_id\")\r\n"
					+ "			values(?, ?, ?);";
			
			PreparedStatement requestReimbursement = conn.prepareStatement(sql);
			
			requestReimbursement.setString(1, purpose);
			requestReimbursement.setDouble(2, amount);
			requestReimbursement.setInt(3, userId);
			
			requestReimbursement.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
