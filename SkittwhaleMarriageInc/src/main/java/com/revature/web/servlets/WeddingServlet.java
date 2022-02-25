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
public class WeddingServlet extends HttpServlet {
	private final UserService userService;
	private final ObjectMapper mapper;
	public WeddingServlet(UserService userService, ObjectMapper mapper) {
		this.userService = userService;
		this.mapper = mapper;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("<h1>Plan your Marriage</h1>"
							 + "<form method='post' action='wedding'>"
							 	+ "<label for='weddingname'>Wedding Name: </label>"
							 	+ "<input type='text' id='weddingname' name='weddingname'></input><br/>"
							 	+ "<label for='weddingdate'>Set your Date: </label>"
							 	+ "<input type='text' id='weddingdate' name='weddingdate'></input><br/>"
							 	+ "<label for='budget'>Set your Budget: </label>"
							 	+ "<input type='text' id='budget' name='budget'></input><br/>"
							 	+ "<label for='venues'>Select your Venue: </label>"
							 	+ "<select id='venues' name='venues'>"
							 	
							 		// Add Venues
							 		
							 	+ "</select><br/>"
							 	+ "<label for='caterers'>Select your Caterer: </label>"
							 	+ "<select id='caterers' name='caterers'>"
							 	
							 		// Add Caterers
							 		
							 	+ "</select><br/>"
							 	+ "<label for='florists'>Select your Florist: </label>"
							 	+ "<select id='florists' name='florists'>"
							 	
							 		// Add Florists
							 		
							 	+ "</select><br/>"
							 	+ "<label for='musicians'>Select your Musician: </label>"
							 	+ "<select id='musicians' name='musicians'>"
							 	
							 		// Add Musicians
							 		
							 	+ "</select><br/>"
							 	+ "<label for='photographers'>Select your Photographer: </label>"
							 	+ "<select id='photographers' name='photographers'>"
							 	
							 		// Add Photographers
							 		
							 	+ "</select><br/>"
							 	+ "<input type='submit' value='Create your Wedding'></input>"
							 + "</form>");
	}
	
}
