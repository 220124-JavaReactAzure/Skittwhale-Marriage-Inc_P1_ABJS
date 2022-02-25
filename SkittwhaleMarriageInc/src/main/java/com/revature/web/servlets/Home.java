package com.revature.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.UserService;

@SuppressWarnings("serial")
public class Home extends HttpServlet {
	private final UserService userService;
	private final ObjectMapper mapper;

	public Home(UserService userService, ObjectMapper mapper) {
		this.userService = userService;
		this.mapper = mapper;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("<h1>MARRIAGE HOME!!!!!!!!!!</h1>"
							 + "<div onClick='logout()'>Go To Login</div>"
							 + "<div onClick='redirectToEmployeeRegister()'>Register as Employee</div>"
							 + "<div onClick='redirectToClientAttendeeRegister()'>Register as Client</div>"
							 + "<script>"
							 	+ "function logout() {"
							 		+ "window.location = './login'"
							 	+ "}"
								 	+ "function redirectToEmployeeRegister() {"
								 		+ "window.location = './employee-register';"
								 	+ "}"
								 	+ "function redirectToClientAttendeeRegister() {"
								 		+ "window.location = './client-attendee-register';"
								 	+ "}"
								 	+ "function redirectToHome() {"
								 		+ "window.location = './home';"
								 	+ "}</script>");
	}

}
