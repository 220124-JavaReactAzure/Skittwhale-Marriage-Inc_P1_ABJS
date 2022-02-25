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

public class Florists extends HttpServlet{
	private final UserService userService;
	private final ObjectMapper mapper;
	private final ServicesService servService;
	private final WeddingService weddService;
	
	public Florists(UserService userService, ServicesService servService, WeddingService weddService, ObjectMapper mapper) {
		this.userService = userService;
		this.mapper = mapper;
		this.servService = servService;
		this.weddService = weddService;
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("<h1>Florists</h1>");
		resp.getWriter().write("<h2>Want to pick out flowers for your pokemons' wedding?</h2>");
		resp.getWriter().write("<p>Here is a list of our florists:</p>");
	}
	
}
