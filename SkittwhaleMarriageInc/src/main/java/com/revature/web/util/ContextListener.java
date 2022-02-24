package com.revature.web.util;



import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDAO;
import com.revature.services.UserService;
import com.revature.web.servlets.Attendee;
import com.revature.web.servlets.EmployeeRegister;

public class ContextListener implements ServletContextListener{
	
	private final Logger logger = LogManager.getLogger();
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("contextInitialized");
		ObjectMapper mapper = new ObjectMapper();
		
		UserDAO userDAO = new UserDAO();
		UserService userService=  new UserService(userDAO);
		
		Attendee attendeeServlet = new Attendee(userService, mapper);
		EmployeeRegister employeeRegisterServlet = new EmployeeRegister(userService, mapper);
		
		ServletContext context = sce.getServletContext();
		
		context.addServlet("Attendee", attendeeServlet).addMapping("/attendee");
		context.addServlet("EmployeeRegister", employeeRegisterServlet).addMapping("/employee-register"); 
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
		logger.info("contextDestroyed");
	}
	
}
