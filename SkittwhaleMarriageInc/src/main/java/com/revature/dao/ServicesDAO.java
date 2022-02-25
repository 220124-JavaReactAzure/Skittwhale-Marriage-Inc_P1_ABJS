package com.revature.dao;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Services;
import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class ServicesDAO {

	

	public boolean addService(Services serv) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(serv);

			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	public List<Services> getAllServices() {
		try {
			Session session = HibernateUtil.getSession();
			List<Services> serv = session.createQuery("FROM serviceid").list();
			return serv;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public Services findByServicesId(String serviceId) {
		try {
			Session session = HibernateUtil.getSession();
			Services serv = session.get(Services.class, serviceId);
			if (serviceId == null) {
				return null;
			} else {
				return serv;
			}

		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		}finally {
			HibernateUtil.closeSession();
		}

	}

	public void updateServiceWithSessionMethod(Services serv) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.merge(serv);
			transaction.commit();
			

		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			Logger.getLogger("").warning("did not persist");
		}finally {
			HibernateUtil.closeSession();
		}

	}

	public void updateServiceWithHQL(Services serv) {
		// TODO Auto-generated method stub

	}

}
