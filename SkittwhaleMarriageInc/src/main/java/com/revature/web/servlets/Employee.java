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
public class Employee extends HttpServlet {
	private final UserService userService;
	private final ObjectMapper mapper;
	public Employee(UserService userService, ObjectMapper mapper) {
		this.userService = userService;
		this.mapper = mapper;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("<h1>Hello Employee!</h1>"
							 + "<form method='post' action='employee'>"
							 	+ "<label>Venue Name: </label>"
							 	+ "<input type='text' id='venuename' name='venuename'></input><br/>"
							 	+ "<label>Venue Cost: </label>"
							 	+ "<input type='text' id='venuecost' name='venuecost'></input><br/>"
							 	+ "<input type='hidden' name='servicetype' value='1'"
							 	+ "<input type='submit' value='Add New Venue'></input>"
							 + "</form>"
							 + "<form method='post' action='employee'>"
							 	+ "<label>Florist Name: </label>"
							 	+ "<input type='text' id='floristname' name='floristname'></input><br/>"
							 	+ "<label>Venue Cost: </label>"
							 	+ "<input type='text' id='floristcost' name='floristcost'></input><br/>"
							 	+ "<input type='hidden' name='servicetype' value='2'"
							 	+ "<input type='submit' value='Add New Florist'></input>"
							 + "</form>"
							 + "<form method='post' action='employee'>"
							 	+ "<label>Musician Name: </label>"
							 	+ "<input type='text' id='musicianname' name='musicianname'></input><br/>"
							 	+ "<label>Venue Cost: </label>"
							 	+ "<input type='text' id='musiciancost' name='musiciancost'></input><br/>"
							 	+ "<input type='hidden' name='servicetype' value='3'"
							 	+ "<input type='submit' value='Add New Musician'></input>"
							 + "</form>"
							 + "<form method='post' action='employee'>"
							 	+ "<label>Caterer Name: </label>"
							 	+ "<input type='text' id='caterername' name='caterername'></input><br/>"
							 	+ "<label>Venue Cost: </label>"
							 	+ "<input type='text' id='caterercost' name='caterercost'></input><br/>"
							 	+ "<input type='hidden' name='servicetype' value='4'"
							 	+ "<input type='submit' value='Add New Caterer'></input>"
							 + "</form>"
							 + "<form method='post' action='employee'>"
							 	+ "<label>Photographer Name: </label>"
							 	+ "<input type='text' id='photographername' name='photographername'></input><br/>"
							 	+ "<label>Venue Cost: </label>"
							 	+ "<input type='text' id='photographercost' name='photographercost'></input><br/>"
							 	+ "<input type='hidden' name='servicetype' value='5'"
							 	+ "<input type='submit' value='Add New Photographer'></input>"
							 + "</form>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
