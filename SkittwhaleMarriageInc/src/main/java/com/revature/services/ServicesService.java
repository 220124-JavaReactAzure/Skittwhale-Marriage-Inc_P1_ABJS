package com.revature.services;

import java.util.List;

import com.revature.dao.ServicesDAO;
import com.revature.models.Services;



public class ServicesService {
	private final ServicesDAO servDAO;
	
	public ServicesService(ServicesDAO servDAO) {
		this.servDAO= servDAO;
	}
	
	public boolean addUser(Services serv) {
		return servDAO.addService(serv);
	}
	
	public List<Services> getAllUsers(){
		return servDAO.getAllServices();
	}
	
	//will probably be string since uuid
	public Services getServicesById(String id) {
		return servDAO.findByServicesId(id);
	}
	
	public void updateServicesWithSessionMethod(Services serv) {
		servDAO.updateServiceWithSessionMethod(serv);
	}
	
	public void updateUserWithHQL(Services serv) {
		servDAO.updateServiceWithHQL(serv);
	}
}
