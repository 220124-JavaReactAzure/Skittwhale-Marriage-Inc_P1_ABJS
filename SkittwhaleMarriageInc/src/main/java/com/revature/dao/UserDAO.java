package com.revature.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class UserDAO {

	public User getUserByID;

	public boolean addUser(User user) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	public List<User> getAllUsers() {
		try {
			Session session = HibernateUtil.getSession();
			List<User> users = session.createQuery("FROM username").list();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	public User findByUsername(String username) {

		try {
			Session session = HibernateUtil.getSession();
			User user = session.get(User.class, username);
			if (username == null) {
				return null;
			} else {
				return user;
			}

		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	public void updateUserWithSessionMethod(User user) {
		// TODO Auto-generated method stub

	}

	public void updateUserWithHQL(User user) {
		// TODO Auto-generated method stub

	}

}
