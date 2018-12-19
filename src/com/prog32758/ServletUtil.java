package com.prog32758;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * Utility class to redirect servlet or forward servlet response & request to jsp/html pages
 * 
 */
public class ServletUtil {

	// method to forward request and reponse object to given url string
	public static void forward(String url, HttpServletRequest req, HttpServletResponse resp) {
		// request dispatcher from request object
		RequestDispatcher rd = req.getRequestDispatcher(url);
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
	}
	
	// method to redirect to given string url
	public static void redirect(String url, HttpServletResponse resp) {
		try {
			// send redirect with response object
			resp.sendRedirect(url);
		} catch (IOException e) {
			e.getMessage();
		}
	}
}
