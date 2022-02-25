package com.revature.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;


@SuppressWarnings("serial")
public class ClientAttendeeRegister extends HttpServlet {
	private final UserService userService;
	private final ObjectMapper mapper;
	public ClientAttendeeRegister(UserService userService, ObjectMapper mapper) {
		this.userService = userService;
		this.mapper = mapper;
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("<h1>MARRIAGE EMPLOYEE REGISTER!!!</h1>"
				 + "<form method='post' action='client-attendee-register'>"
				 	+ "<label for='email'>Email: </label>"
				 	+ "<input type='text' id='email' name='email'></input><br/>"
				 	+ "<label for='firstname'>First Name: </label>"
				 	+ "<input type='text' id='firstname' name='firstname'></input><br/>"
				 	+ "<label for='lastname'>Last Name: </label>"
				 	+ "<input type='text' id='lastname' name='lastname'></input><br/>"
				 	+ "<label for='password'>Password: </label>"
				 	+ "<input type='password' id='password' name='password'></input><br/>"
				 	+ "<input type='checkbox' id='betrothed' name='betrothed'>Are you getting married? </input>"
				 	+ "<input type='submit' value='Register as Employee'></input>"
				 + "</form>"
				 + "<div onClick='redirectToHome()'>Fake Register(for testing)</div>"
				 + "<div onClick='redirectToLogin()'>Redirect To Login</div>"
				 + "<script>"
				 	+ "function redirectToHome() {"
				 		+ "window.location = './home';"
				 	+ "}"
				 	+ "function redirectToLogin() {"
				 		+ "window.location = './login';"
				 	+ "}"
				 + "</script>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String password = req.getParameter("password");
		
		boolean isBetrothed = false;
		if(req.getParameter("betrothed") != null) {
			isBetrothed = true;
		}
		if(isBetrothed) {
			User newUser = new User(email, firstname, lastname, password, false, 1, 1, 3, null);
			userService.addUser(newUser);
		}
		else {
			User newUser = new User(email, firstname, lastname, password, false, 1, 1, 2, null);
			userService.addUser(newUser);
		}
		
//		System.out.println("Username: " + username + "\nPassword: " + password + "\nBetrothed: " + isBetrothed);
//		
//		PrintWriter writer = resp.getWriter();
//		
//		String htmlResponse = "<html>"
//							+ "<h2>The username you entered is: " + username + "<br/>"
//							+ "Your password is: " + password + "<br/>"
//							+ "Are you getting married: " + isBetrothed + "</h2>"
//							+ "</html>";
//		
//		writer.println(htmlResponse);
	}
	
}
