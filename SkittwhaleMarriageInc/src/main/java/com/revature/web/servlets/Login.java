package com.revature.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;

@SuppressWarnings("serial")
public class Login extends HttpServlet {
	private final UserService userService;
	private final ObjectMapper mapper;
	public Login(UserService userService, ObjectMapper mapper) {
		this.userService = userService;
		this.mapper = mapper;
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("<h1>MARRIAGE!</h1>"
							 + "<form method='post' action='login'>"
							 	+ "<label for='username'>Username: </label>"
							 	+ "<input type='text' id='username' name='username'></input><br/>"
							 	+ "<label for='password'>Password: </label>"
							 	+ "<input type='password' id='password' name='password'></input><br/>"
							 	+ "<input type='submit' value='Login'></input>"
							 + "</form>"
							 + "<div onClick='redirectToHome()'>Fake Login(for testing)</div>"
							 + "<div onClick='redirectToEmployeeRegister()'>Register as Employee</div>"
							 + "<div onClick='redirectToClientAttendeeRegister()'>Register as Client</div>"
							 + "<script>"
							 	+ "function redirectToEmployeeRegister() {"
							 		+ "window.location = './employee-register';"
							 	+ "}"
							 	+ "function redirectToClientAttendeeRegister() {"
							 		+ "window.location = './client-attendee-register;'"
							 	+ "}"
							 	+ "function redirectToHome() {"
							 		+ "window.location = './home';"
							 	+ "}"
							 + "</script>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User newUser = new User(username, password);
		if(userService.findByUsername(newUser)) {
			switch(newUser.getUsertypeid()) {
			case 1:
				resp.sendRedirect("/employee");
				break;
			case 2:
				resp.sendRedirect("/attendee");
				break;
			case 3:
				resp.sendRedirect("/wedding");
				break;
			default:
				System.out.println("This user has no type id");
				resp.sendRedirect("/login");
				break;
			}
		}
		
		
		/*System.out.println("Username: " + username + "\nPassword: " + password);
		
		PrintWriter writer = resp.getWriter();
		
		String htmlResponse = "<html>"
							+ "<h2>The username you entered is: " + username + "<br/>"
							+ "Your password is: " + password + "</h2>"
							+ "</html>";
		
		writer.println(htmlResponse);
		*/
	}
	
}
