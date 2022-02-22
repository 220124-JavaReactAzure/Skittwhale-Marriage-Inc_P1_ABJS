package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/home")
@SuppressWarnings("serial")
public class Home extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("<h1>MARRIAGE HOME!!!!!!!!!!</h1>"
							 + "<div onClick='logout()'>Fake Logout</div>"
							 + "<script>"
							 	+ "function logout() {"
							 		+ "window.location = './login'"
							 	+ "}"
							 + "</script>");
	}
	
}
