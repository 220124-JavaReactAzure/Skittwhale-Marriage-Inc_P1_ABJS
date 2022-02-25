package com.revature.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Services;
import com.revature.services.ServicesService;
import com.revature.services.UserService;

@SuppressWarnings("serial")
public class Employee extends HttpServlet {
	private final UserService userService;
	private final ServicesService servService;
	private final ObjectMapper mapper;
	private static String message = "";

	public Employee(UserService userService, ServicesService servService, ObjectMapper mapper) {
		this.userService = userService;
		this.servService = servService;
		this.mapper = mapper;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("<h1>Hello Employee!</h1>"
				+ "<h2>Use the forms below to add new services for our company.</h2>" + message
				+ "<form method='post' action='employee'>" + "<label>Venue Name: </label>"
				+ "<input type='text' id='venuename' name='venuename'></input><br/>" + "<label>Venue Cost: </label>"
				+ "<input type='number' id='venuecost' name='venuecost'></input><br/>"
				+ "<input type='hidden' name='servicetype' value='1'></input>"
				+ "<input type='submit' value='Add New Venue'></input>" + "</form>"
				+ "<form method='post' action='employee'>" + "<label>Florist Name: </label>"
				+ "<input type='text' id='floristname' name='floristname'></input><br/>" + "<label>Venue Cost: </label>"
				+ "<input type='number' id='floristcost' name='floristcost'></input><br/>"
				+ "<input type='hidden' name='servicetype' value='2'></input>"
				+ "<input type='submit' value='Add New Florist'></input>" + "</form>"
				+ "<form method='post' action='employee'>" + "<label>Musician Name: </label>"
				+ "<input type='text' id='musicianname' name='musicianname'></input><br/>"
				+ "<label>Venue Cost: </label>"
				+ "<input type='number' id='musiciancost' name='musiciancost'></input><br/>"
				+ "<input type='hidden' name='servicetype' value='3'></input>"
				+ "<input type='submit' value='Add New Musician'></input>" + "</form>"
				+ "<form method='post' action='employee'>" + "<label>Caterer Name: </label>"
				+ "<input type='text' id='caterername' name='caterername'></input><br/>" + "<label>Venue Cost: </label>"
				+ "<input type='number' id='caterercost' name='caterercost'></input><br/>"
				+ "<input type='hidden' name='servicetype' value='4'></input>"
				+ "<input type='submit' value='Add New Caterer'></input>" + "</form>"
				+ "<form method='post' action='employee'>" + "<label>Photographer Name: </label>"
				+ "<input type='text' id='photographername' name='photographername'></input><br/>"
				+ "<label>Venue Cost: </label>"
				+ "<input type='number' id='photographercost' name='photographercost'></input><br/>"
				+ "<input type='hidden' name='servicetype' value='5'></input>"
				+ "<input type='submit' value='Add New Photographer'></input>" + "</form>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int servicetype = Integer.parseInt(req.getParameter("servicetype"));
		String serviceid = "";
		String servicename = "";
		double servicecost = 0.0;
		switch (servicetype) {
		case (1):
			serviceid = req.getParameter("venuename");
			servicename = req.getParameter("venuename");
			Services existingServ = servService.getServicesById(serviceid);
			if (existingServ == null) {
				servicecost = Double.parseDouble(req.getParameter("venuecost"));
				Services venueserv = new Services(serviceid, servicename, servicecost, servicetype);
				if(servService.addService(venueserv)) {
					message = "Venue added";
					resp.sendRedirect("./employee");					
				} else {
					message = "Servicename already exists";
					resp.sendRedirect("./employee");
				}
			} else {
				message = "Servicename already exists";
				resp.sendRedirect("./employee");

			}
			break;

		case (2):
			serviceid = req.getParameter("floristname");
			servicename = req.getParameter("floristname");
			Services existingServ2 = servService.getServicesById(serviceid);
			if (existingServ2 == null) {
				servicecost = Double.parseDouble(req.getParameter("floristcost"));
				Services floristserv = new Services(serviceid, servicename, servicecost, servicetype);
				if(servService.addService(floristserv)) {
					message = "Florist added";
					resp.sendRedirect("./employee");
				} else {
					resp.sendRedirect("./employee");
					message = "Florist servicename already exists";
				}
			} else {
				resp.sendRedirect("./employee");
				message = "Florist servicename already exists";
			}

			break;
		case (3):
			serviceid = req.getParameter("musicianname");
			servicename = req.getParameter("musicianname");
			Services existingServ3 = servService.getServicesById(serviceid);
			if (existingServ3 == null) {
				servicecost = Double.parseDouble(req.getParameter("musiciancost"));
				Services musicianserv = new Services(serviceid, servicename, servicecost, servicetype);
				if(servService.addService(musicianserv)) {					
					message = "Musician added";
					resp.sendRedirect("./employee");
				} else {
					message = "Musician servicename already exists";
					resp.sendRedirect("./employee");
				}
			} else {				
				message = "Musician servicename already exists";
				resp.sendRedirect("./employee");
			}

			break;
		case (4):
			serviceid = req.getParameter("caterername");
			servicename = req.getParameter("caterername");
			Services existingSer4 = servService.getServicesById(serviceid);
			if (existingSer4 == null) {
				servicecost = Double.parseDouble(req.getParameter("caterercost"));
				Services catererserv = new Services(serviceid, servicename, servicecost, servicetype);
				if(servService.addService(catererserv)) {
					message = "Caterer added";
					resp.sendRedirect("./employee");					
				} else {
					message = "Caterer servicename already exists";
					resp.sendRedirect("./employee");
				}
			} else {				
				message = "Caterer servicename already exists";
				resp.sendRedirect("./employee");
			}

			break;
		case (5):
			serviceid = req.getParameter("photographername");
			servicename = req.getParameter("photographername");
			Services existingServ5 = servService.getServicesById(serviceid);
			if (existingServ5 == null) {
				servicecost = Double.parseDouble(req.getParameter("photographercost"));
				Services photographerserv = new Services(serviceid, servicename, servicecost, servicetype);
				if(servService.addService(photographerserv)) {
					message = "Photographer added";
					resp.sendRedirect("./employee");					
				} else {
					message = "Photographer servicename already exists";
					resp.sendRedirect("./employee");	
				}
			} else {
				message = "Photographer servicename already exists";
				resp.sendRedirect("./employee");				
			}

			break;
		default:
			break;
		}
	}

}
