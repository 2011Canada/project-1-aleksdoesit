package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.exceptions.AbstractHttpException;

public class ErrorController {

	public void handle(HttpServletRequest req, HttpServletResponse resp, Throwable t) throws IOException {

		if (t == null) {

			resp.setStatus(500);
			resp.getWriter().write("Oops! Something went terribly wrong.");
			return;

		}

		if (t instanceof AbstractHttpException) {

			AbstractHttpException err = (AbstractHttpException) t;
			System.out.println(t.getMessage());
			resp.setStatus(err.getStatusCode());
			resp.getWriter().write(err.getMessage());

		} else {

			t.printStackTrace();
			resp.setStatus(500);
			resp.getWriter().write("Oops! Something went terribly wrong.");

		}

	}

}
