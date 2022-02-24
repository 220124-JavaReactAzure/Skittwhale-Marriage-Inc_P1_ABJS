package com.revature.services;

import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.models.User;

public class ServicesService {
	private final UserDAO userDAO;
	
	public ServicesService(UserDAO userDAO) {
		this.userDAO= userDAO;
	}
	
	public boolean addUser(User user) {
		return userDAO.addUser(user);
	}
	
	public List<User> getAllUsers(){
		return userDAO.getAllUsers();
	}
	
	//will probably be string since uuid
	public User getUserById(int id) {
		return userDAO.getUserByID;
	}
	
	public void updateUserWithSessionMethod(User user) {
		userDAO.updateUserWithSessionMethod(user);
	}
	
	public void updateUserWithHQL(User user) {
		userDAO.updateUserWithHQL(user);
	}
}
