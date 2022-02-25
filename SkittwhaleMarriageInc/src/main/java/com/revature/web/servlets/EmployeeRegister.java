package com.revature.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;

@SuppressWarnings("serial")
public class EmployeeRegister extends HttpServlet {

	private UserService userService;
	private ObjectMapper mapper;

	public EmployeeRegister(UserService userService, ObjectMapper mapper) {
		this.userService = userService;
		this.mapper = mapper;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.getWriter().write("<h1>Skittwhale Marriage Inc Employee Register</h1>"
							 + "<form method='post' action='employee-register'>"
							 	+ "<label for='email'>Email: </label>"
							 	+ "<input type='text' id='email' name='email'></input><br/>"
							 	+ "<label for='firstname'>First Name: </label>"
							 	+ "<input type='text' id='firstname' name='firstname'></input><br/>"
							 	+ "<label for='lastname'>Last Name: </label>"
							 	+ "<input type='text' id='lastname' name='lastname'></input><br/>"
							 	+ "<label for='password'>Password: </label>"
							 	+ "<input type='password' id='password' name='password'></input><br/>"
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
		
		User existingUser = userService.findByEmail(email);
		
		if(email != existingUser.getEmail()) {
			User newUser = new User(email, firstname, lastname, password, false, 1, 1, 1, null);
			if(userService.addUser(newUser)) {
				resp.sendRedirect("./employee");
			} else {
				resp.sendRedirect("./employee-register");
			}			
		} else {
			resp.sendRedirect("./employee-register");
		}
		
		
//		System.out.println("Username: " + username + "\nPassword: " + password);
//		
//		PrintWriter writer = resp.getWriter();
//		
//		String htmlResponse = "<html>"
//							+ "<h2>The username you entered is: " + username + "<br/>"
//							+ "Your password is: " + password + "</h2>"
//							+ "</html>";
//		
//		writer.println(htmlResponse);
	}
	
}
