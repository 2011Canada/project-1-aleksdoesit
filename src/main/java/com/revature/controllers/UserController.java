package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.UnauthenticatedException;
import com.revature.exceptions.UnauthorizedException;
import com.revature.exceptions.loginAsUserException;
import com.revature.models.Credentials;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repositories.UserPostgresDAO;
import com.revature.services.UserService;
import com.revature.services.UserServiceImplementation;

public class UserController {

	private UserService us = new UserServiceImplementation(new UserPostgresDAO());
	private ObjectMapper om = new ObjectMapper();

	public void findAllUsers(HttpServletRequest req, HttpServletResponse res) throws IOException {

		HttpSession sess = req.getSession();

		if (sess.getAttribute("User-Role") == null) {

			throw new UnauthenticatedException();

		} else if (!sess.getAttribute("User-Role").equals("Admin")) {

			throw new UnauthorizedException();

		}

		List<User> allUsers = us.getAllUsers();

		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(allUsers));

	}

	public void requestReimbursement(HttpServletRequest req, HttpServletResponse res) throws IOException {

		Reimbursement reimbursement = om.readValue(req.getInputStream(), Reimbursement.class);
		HttpSession sess = req.getSession(false);

		if (sess.getAttribute("User-Role") == null) {

			throw new UnauthenticatedException();

		} else if (!sess.getAttribute("User-Role").equals("User")) {

			throw new loginAsUserException();

		}

		us.requestReimbursement(reimbursement.getAmount(), reimbursement.getDescription(),
				(Integer) sess.getAttribute("User-Id"));

		System.out.println((Integer) sess.getAttribute("User-Id"));
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString("worked"));

	}

	public void approveReimbursement(HttpServletRequest req, HttpServletResponse res) throws IOException {

		Reimbursement reimbursement = om.readValue(req.getInputStream(), Reimbursement.class);
		HttpSession sess = req.getSession(false);

		if (sess.getAttribute("User-Role") == null) {

			throw new UnauthenticatedException();

		} else if (!sess.getAttribute("User-Role").equals("Admin")) {

			throw new UnauthorizedException();

		}

		us.approveReimbursement(reimbursement.getReimbursementId());

		System.out.println(reimbursement.getReimbursementId());
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString("worked"));

	}
	
	public void rejectReimbursement(HttpServletRequest req, HttpServletResponse res) throws IOException {

		Reimbursement reimbursement = om.readValue(req.getInputStream(), Reimbursement.class);
		HttpSession sess = req.getSession(false);

		if (sess.getAttribute("User-Role") == null) {

			throw new UnauthenticatedException();

		} else if (!sess.getAttribute("User-Role").equals("Admin")) {

			throw new UnauthorizedException();

		}

		us.rejectReimbursement(reimbursement.getReimbursementId());

		System.out.println(reimbursement.getReimbursementId());
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString("worked"));

	}
	
	public void requestEmployeeHistory(HttpServletRequest req, HttpServletResponse res) throws IOException {

		Reimbursement reimbursement = om.readValue(req.getInputStream(), Reimbursement.class);
		HttpSession sess = req.getSession();

		if (sess.getAttribute("User-Role") == null) {

			throw new UnauthenticatedException();

		} else if (!sess.getAttribute("User-Role").equals("Admin")) {

			throw new UnauthorizedException();

		}

		List<Reimbursement> printAllForUser = us.requestUserHistory(reimbursement.getUserId());

		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(printAllForUser));

	}
	
	public void requestSelfHistory(HttpServletRequest req, HttpServletResponse res) throws IOException {

		HttpSession sess = req.getSession();

		if (sess.getAttribute("User-Role") == null) {

			throw new UnauthenticatedException();

		} else if (!sess.getAttribute("User-Role").equals("User")) {

			throw new UnauthorizedException();

		}

		List<Reimbursement> printAllForUser = us.requestUserHistory((Integer) sess.getAttribute("User-Id"));

		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(printAllForUser));

	}

}
