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
							 + "<div onClick='redirectToHome()'>Fake Register(for testing)</div>"
							 + "<div onClick='redirectToLogin()'>Redirect To Login</div>"
							 + "<script>"
							 	+ "function redirectToHome() {"
							 		+ "window.location = './home'"
							 	+ "}"
							 	+ "function redirectToLogin() {"
							 		+ "window.location = './login'"
							 	+ "}"
							 + "</script>");
	}
	
}
