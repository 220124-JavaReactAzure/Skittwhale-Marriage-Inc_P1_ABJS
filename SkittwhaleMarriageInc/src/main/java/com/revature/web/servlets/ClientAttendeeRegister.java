package com.revature.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/client-attendee-register")
@SuppressWarnings("serial")
public class ClientAttendeeRegister extends HttpServlet {

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
		
		System.out.println("Username: " + username + "\nPassword: " + password + "\nBetrothed: " + isBetrothed);
		
		PrintWriter writer = resp.getWriter();
		
		String htmlResponse = "<html>"
							+ "<h2>The username you entered is: " + username + "<br/>"
							+ "Your password is: " + password + "<br/>"
							+ "Are you getting married: " + isBetrothed + "</h2>"
							+ "</html>";
		
		writer.println(htmlResponse);
	}
	
}
