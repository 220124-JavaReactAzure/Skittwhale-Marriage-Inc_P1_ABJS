package com.revature.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.ServicesService;
import com.revature.services.UserService;
import com.revature.services.WeddingService;

public class Venues extends HttpServlet{
	private final UserService userService;
	private final ObjectMapper mapper;
	private final ServicesService servService;
	private final WeddingService weddService;
	
	public Venues(UserService userService, ServicesService servService, WeddingService weddService, ObjectMapper mapper) {
		this.userService = userService;
		this.mapper = mapper;
		this.servService = servService;
		this.weddService = weddService;
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().write("<h1>Venues</h1>");
		resp.getWriter().write("<h2>This is the region of Hoenn.</h2>");
		resp.getWriter().write("<p>Where are your Pokemon getting married?</p>");
	}

}
