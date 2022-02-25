package com.revature.dao;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.models.Weddings;
import com.revature.util.HibernateUtil;

public class WeddingDAO {

	public boolean addWedding(Weddings wedding) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(wedding);

			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Weddings> getAllWeddings() {
		try {
			Session session = HibernateUtil.getSession();
			List<Weddings> wedding = session.createQuery("FROM Weddings").list();
			return wedding;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	public Weddings findByWeddingId(String weddingId) {

		try {
			Session session = HibernateUtil.getSession();
			Weddings wedding = session.get(Weddings.class, weddingId);
			if (wedding == null) {
				return null;
			} else {
				return wedding;
			}

		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		}finally {
			HibernateUtil.closeSession();
		}

	}

	public void updateWeddingWithSessionMethod(Weddings wedding) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.merge(wedding);
			transaction.commit();
			

		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			Logger.getLogger("").warning("did not persist");
		}finally {
			HibernateUtil.closeSession();
		}

	}

	public void updateWeddingWithHQL(Weddings wedding) {
		// TODO Auto-generated method stub

	}

}
