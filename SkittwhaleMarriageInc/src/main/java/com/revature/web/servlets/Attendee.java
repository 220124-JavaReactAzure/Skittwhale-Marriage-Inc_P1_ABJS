package com.revature.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Services;
import com.revature.models.Weddings;
import com.revature.services.UserService;
import com.revature.services.WeddingService;

@SuppressWarnings("serial")
public class Attendee extends HttpServlet {

	private final UserService userService;
	private final WeddingService weddService;
	private final ObjectMapper mapper;
	
	private List<Weddings> weddOptions = new ArrayList<>();
	
	public Attendee(UserService userService, WeddingService weddService, ObjectMapper mapper) {
		this.userService = userService;
		this.weddService = weddService;
		this.mapper = mapper;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		weddOptions = weddService.getAllWeddings();
		String weddings = "";
		for(int i = 0; i < weddOptions.size(); i++) {
			weddings += "<option value='" + weddOptions.get(i).getWeddingId() +"'>" + weddOptions.get(i).getWeddingId() + "</option>\n";
		}
		resp.getWriter().write("<h1>Attendee Information</h1>"
							 + "<form method='post' action='attendee'>"
							 	+ "<label for='weddings'>Select the wedding you would like to attend: </label>"
							 	+ "<select id='weddings' name='weddings'>"
							 	+ weddings
							 	+ "</select><br/>"
							 	+ "<label for='mealtypes'>Select your meal Type: </label>"
							 	+ "<select id='mealtypes' name='mealtypes'>"
							 		+ "<option value='meat'>Meat</option>"
							 		+ "<option value='fish'>Fish</option>"
							 		+ "<option value='veggie'>Veggie</option>"
							 	+ "</select><br/>"
							 	+ "<label for='email'>Email: </label>"
							 	+ "<input type='text' id='email' name='email'></input><br/>"
							 	+ "<input type='checkbox' id='plusone' name='plusone'>Will you bring another guest? </input><br/>"
							 	+ "<input type='submit' value='Attend the Wedding'></input>"
							 + "</form>");
	}
	
}
