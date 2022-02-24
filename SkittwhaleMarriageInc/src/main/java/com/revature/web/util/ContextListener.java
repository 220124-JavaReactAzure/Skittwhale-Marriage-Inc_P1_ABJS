package com.revature.web.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.revature.dao.UserDAO;
import com.revature.web.servlets.WeddingServlet;
import com.revature.services.UserService;
import com.revature.web.servlets.Attendee;
import com.revature.web.servlets.ChooseMeal;
import com.revature.web.servlets.ClientAttendeeRegister;
import com.revature.web.servlets.ConfirmationCancellation;
import com.revature.web.servlets.ContactInformation;
import com.revature.web.servlets.Employee;
import com.revature.web.servlets.EmployeeRegister;
import com.revature.web.servlets.Florists;
import com.revature.web.servlets.Home;
import com.revature.web.servlets.Login;
import com.revature.web.servlets.VenueInformation;
import com.revature.web.servlets.Venues;
import com.revature.web.servlets.WeddingBudget;

@WebListener
public class ContextListener implements ServletContextListener{
	
	private final Logger logger = LogManager.getLogger();
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("contextInitialized");
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate5Module());
		
		UserDAO userDAO = new UserDAO();
		UserService userService=  new UserService(userDAO);
		
		//servlets
		Home homeServlet = new Home(userService, mapper);
		Attendee attendeeServlet = new Attendee(userService, mapper);
		ChooseMeal chooseMealServlet = new ChooseMeal(userService, mapper);
		ClientAttendeeRegister clientAttendeeRegisterServlet = new ClientAttendeeRegister(userService, mapper);
		ConfirmationCancellation confirmationCancellationServlet = new ConfirmationCancellation(userService, mapper);
		ContactInformation contactInformationServlet = new ContactInformation(userService, mapper);
		EmployeeRegister employeeRegisterServlet = new EmployeeRegister(userService, mapper);
		Employee employeeServlet = new Employee(userService, mapper); 
		Florists floristsServlet = new Florists(userService, mapper);
		Login loginServlet = new Login(userService,mapper);
		VenueInformation venueInformationservlet = new VenueInformation(userService, mapper);
		Venues venueServlet = new Venues(userService, mapper);
		WeddingServlet weddingServlet = new WeddingServlet(userService, mapper);
		WeddingBudget weddingBudgetServlet = new WeddingBudget(userService, mapper);
		
		ServletContext context = sce.getServletContext();
		
		//home
		context.addServlet("Home", homeServlet).addMapping("/home");
		
		//login 
		context.addServlet("Login", loginServlet).addMapping("/login");
		
		//register
		context.addServlet("ClientAttendeeRegister", clientAttendeeRegisterServlet).addMapping("/client-attendee-register");
		context.addServlet("EmployeeRegister", employeeRegisterServlet).addMapping("/employee-register");
		
		//attendee
		context.addServlet("Attendee", attendeeServlet).addMapping("/attendee");
		context.addServlet("ConfirmationCancelltaion", confirmationCancellationServlet).addMapping("/attendee/confirmation-cancellation");
		context.addServlet("ContactInformation", contactInformationServlet).addMapping("/attendee/contact-information");
		context.addServlet("VenueInformation", venueInformationservlet).addMapping("/attendee/venue-information");
		
		//client
		context.addServlet("Wedding", weddingServlet).addMapping("/wedding");
		context.addServlet("ChooseMeal", chooseMealServlet).addMapping("/wedding/choose-meal");
		context.addServlet("Florists", floristsServlet).addMapping("/wedding/florists");
		context.addServlet("WeddingBudget", weddingBudgetServlet).addMapping("/wedding/venue");
		context.addServlet("Venues", venueServlet).addMapping("/wedding/venues");
		
		//staff member
		context.addServlet("Employee", employeeServlet).addMapping("/employee");
		
		
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
		logger.info("contextDestroyed");
	}
	
}
