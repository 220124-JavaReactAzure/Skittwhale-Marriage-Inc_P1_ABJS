package com.revature.web.servlets;

import javax.servlet.http.HttpServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.UserService;

public class Photographers extends HttpServlet{
	private final UserService userService;
	private final ObjectMapper mapper;
	public Photographers(UserService userService, ObjectMapper mapper) {
		this.userService = userService;
		this.mapper = mapper;
	}
}
