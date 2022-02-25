package com.revature.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.UserService;

@SuppressWarnings("serial")
public class Attendee extends HttpServlet {

	private final UserService userService;
	private final ObjectMapper mapper;
	public Attendee(UserService userService, ObjectMapper mapper) {
		this.userService = userService;
		this.mapper = mapper;
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("<h1>Attendee Information</h1>"
							 + "<form method='post' action='attendee'>"
							 	+ "<label for='weddings'>Select the wedding you would like to attend: </label>"
							 	+ "<select id='weddings' name='weddings'>"
							 
							 		// Add existing weddings from our database here; STRETCH GOAL: Exclude the default wedding
							 	
							 	+ "</select><br/>"
							 	+ "<label for='mealtypes'>Select your meal Type: </label>"
							 	+ "<select id='mealtypes' name='mealtypes'>"
							 		+ "<option value='meat'></option>"
							 		+ "<option value='fish'></option>"
							 		+ "<option value='veggie'></option>"
							 	+ "</select><br/>"
							 	+ "<label for='email'>Email: </label>"
							 	+ "<input type='text' id='email' name='email'></input>"
							 	+ "<input type='checkbox' id='plusone' name='plusone>Will you bring another guest? </input>"
							 	+ "<input type='submit' value='Attend the Wedding'></input>"
							 + "</form>");
	}
	
}
