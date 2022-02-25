package com.revature.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Services;
import com.revature.models.Weddings;
import com.revature.services.ServicesService;
import com.revature.services.UserService;
import com.revature.services.WeddingService;

@SuppressWarnings("serial")
public class WeddingServlet extends HttpServlet {
	private final UserService userService;
	private final ObjectMapper mapper;
	private final ServicesService servService;
	private final WeddingService weddService;

	private List<Services> servOptions = new ArrayList<>();

	public WeddingServlet(UserService userService, ServicesService servService, WeddingService weddService,
			ObjectMapper mapper) {
		this.userService = userService;
		this.mapper = mapper;
		this.servService = servService;
		this.weddService = weddService;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		servOptions = servService.getAllServices();
		String venues = "";
		String caterers = "";
		String florists = "";
		String musicians = "";
		String photographers = "";
		for (int i = 0; i < servOptions.size(); i++) {
			if(servOptions.get(i).getServiceTypeId() == 1) {
				venues += "<option value='" + servOptions.get(i).getServiceId() +"'>" + servOptions.get(i).getServiceId() + "</option>\n";				
			} else if(servOptions.get(i).getServiceTypeId() == 2) {
				florists += "<option value='" + servOptions.get(i).getServiceId() +"'>" + servOptions.get(i).getServiceId() + "</option>\n";
			} else if(servOptions.get(i).getServiceTypeId() == 3) {
				caterers += "<option value='" + servOptions.get(i).getServiceId() +"'>" + servOptions.get(i).getServiceId() + "</option>\n";
			} else if(servOptions.get(i).getServiceTypeId() == 4) {
				musicians += "<option value='" + servOptions.get(i).getServiceId() +"'>" + servOptions.get(i).getServiceId() + "</option>\n";
			} else if(servOptions.get(i).getServiceTypeId() == 5) {
				photographers += "<option value='" + servOptions.get(i).getServiceId() +"'>" + servOptions.get(i).getServiceId() + "</option>\n";
			}
		}
		resp.getWriter().write("<h1>Plan your Marriage</h1>" + "<form method='post' action='wedding'>"
				+ "<label for='weddingname'>Wedding Name: </label>"
				+ "<input type='text' id='weddingname' name='weddingname'></input><br/>"
				+ "<label for='weddingdate'>Set your Date: </label>"
				+ "<input type='text' id='weddingdate' name='weddingdate'></input><br/>"
				+ "<label for='budget'>Set your Budget: </label>"
				+ "<input type='text' id='budget' name='budget'></input><br/>"
				+ "<label for='venues'>Select your Venue: </label>" + "<select id='venues' name='venues'>"
				+ venues
				+ "</select><br/>" + "<label for='caterers'>Select your Caterer: </label>"
				+ "<select id='caterers' name='caterers'>"
				+ caterers
				+ "</select><br/>" + "<label for='florists'>Select your Florist: </label>"
				+ "<select id='florists' name='florists'>"
				+ florists
				+ "</select><br/>" + "<label for='musicians'>Select your Musician: </label>"
				+ "<select id='musicians' name='musicians'>"
				+ musicians
				+ "</select><br/>" + "<label for='photographers'>Select your Photographer: </label>"
				+ "<select id='photographers' name='photographers'>"
				+ photographers
				+ "</select><br/>" + "<input type='submit' value='Create your Wedding'></input>" + "</form>");
	}

}
