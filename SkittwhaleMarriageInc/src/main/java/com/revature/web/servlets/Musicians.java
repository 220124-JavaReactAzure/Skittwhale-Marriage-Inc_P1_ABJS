package com.revature.web.servlets;

import javax.servlet.http.HttpServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.UserService;

public class Musicians extends HttpServlet {
	private final UserService userService;
	private final ObjectMapper mapper;
	public Musicians(UserService userService, ObjectMapper mapper) {
		this.userService = userService;
		this.mapper = mapper;
	}
}
