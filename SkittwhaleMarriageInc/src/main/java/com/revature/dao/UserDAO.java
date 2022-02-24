package com.revature.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class UserDAO {

	public User getUserByID;

	public boolean addUser(User user) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(user);
			HibernateUtil.closeSession();
			
			return true;
		} catch (HibernateException | IOException e){
			e.printStackTrace();
			return false;
		}
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateUserWithSessionMethod(User user) {
		// TODO Auto-generated method stub
		
	}

	public void updateUserWithHQL(User user) {
		// TODO Auto-generated method stub
		
	}
	
}
