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

@WebServlet(value = "/client-attendee-register")
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
				 	+ "<label for='username'>Username: </label>"
				 	+ "<input type='text' id='username' name='username'></input><br/>"
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
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		boolean isBetrothed = false;
		if(req.getParameter("betrothed") != null) {
			isBetrothed = true;
		}
		if(isBetrothed) {
			UUID userId = UUID.randomUUID();
			String email = req.getParameter("email");
			User newUser = new User(userId, username, password, email, false, 1, 1, 3, null);
			userService.addUser(newUser);
		}
		else {
			UUID userId = UUID.randomUUID();
			String email = req.getParameter("email");
			User newUser = new User(userId, username, password, email, false, 1, 1, 2, null);
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
