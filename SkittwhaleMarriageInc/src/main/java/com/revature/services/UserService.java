package com.revature.services;

import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.models.User;

public class UserService {
	private final UserDAO userDAO;
	
	public UserService(UserDAO userDAO) {
		this.userDAO= userDAO;
	}
	
	public boolean addUser(User user) {
		return userDAO.addUser(user);
	}
	
	public List<User> getAllUsers(){
		return userDAO.getAllUsers();
	}
	
	public User getUserById(String id) {
		return userDAO.getUserByID;
	}
	
	public User findByEmail(String email) {
		return userDAO.findByEmail(email);
	}
	
	public void updateUserWithSessionMethod(User user) {
		userDAO.updateUserWithSessionMethod(user);
	}
	
	public void updateUserWithHQL(User user) {
		userDAO.updateUserWithHQL(user);
	}
}
