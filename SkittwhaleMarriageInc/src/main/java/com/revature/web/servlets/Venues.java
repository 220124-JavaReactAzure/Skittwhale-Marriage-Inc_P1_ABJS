package com.revature.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/venues")
public class Venues extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().write("<h1>Venues</h1>");
		resp.getWriter().write("<h2>This is the region of Hoenn.</h2>");
		resp.getWriter().write("<p>Where are your Pokemon getting married?</p>");
	}

}
