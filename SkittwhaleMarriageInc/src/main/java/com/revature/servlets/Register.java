package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Register extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("<h1>MARRIAGE REGISTER!!!</h1>"
							 + "<form>"
							 	+ "<label for='username'>Username: </label>"
							 	+ "<input type='text' id='username' name='username'></input>"
							 	+ "<label for='password'>Password: </label>"
							 	+ "<input type='password' id='password' name='password'></input>"
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
	
}
