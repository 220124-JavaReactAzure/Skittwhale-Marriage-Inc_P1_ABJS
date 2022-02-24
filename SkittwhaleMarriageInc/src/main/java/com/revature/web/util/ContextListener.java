package com.revature.web.util;



import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDAO;
import com.revature.web.servlets.Attendee;

public class ContextListener implements ServletContextListener{
	
	private final Logger logger = LogManager.getLogger();
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("contextInitialized");
		ObjectMapper mapper = new ObjectMapper();
		
		UserDAO userDAO = new UserDAO();
		Attendee attendeeServlet = new Attendee();
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
		logger.info("contextDestroyed");
	}
	
}
