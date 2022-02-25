package com.revature.web.servlets;

import javax.servlet.http.HttpServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.ServicesService;
import com.revature.services.UserService;
import com.revature.services.WeddingService;

public class Musicians extends HttpServlet {
	private final UserService userService;
	private final ObjectMapper mapper;
	private final ServicesService servService;
	private final WeddingService weddService;
	
	public Musicians(UserService userService, ServicesService servService, WeddingService weddService, ObjectMapper mapper) {
		this.userService = userService;
		this.mapper = mapper;
		this.servService = servService;
		this.weddService = weddService;
	}
}
