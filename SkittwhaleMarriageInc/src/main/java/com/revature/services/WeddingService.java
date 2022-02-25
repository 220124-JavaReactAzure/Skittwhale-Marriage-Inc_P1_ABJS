package com.revature.services;

import java.util.List;

import com.revature.dao.WeddingDAO;
import com.revature.models.Weddings;



public class WeddingService {
	private final WeddingDAO weddingDAO;
	
	public WeddingService(WeddingDAO weddingDAO) {
		this.weddingDAO= weddingDAO;
	}
	
	public boolean addWedding(Weddings wedding) {
		return weddingDAO.addWedding(wedding);
	}
	
	public List<Weddings> getAllWeddings(){
		return weddingDAO.getAllWeddings();
	}
	
	//will probably be string since uuid
	public Weddings getUserById(String id) {
		return weddingDAO.findByWeddingId(id);
	}
	
	public void updateWeddingWithSessionMethod(Weddings wedding) {
		weddingDAO.updateWeddingWithSessionMethod(wedding);
	}
	
	public void updateWeddingWithHQL(Weddings wedding) {
		weddingDAO.updateWeddingWithHQL(wedding);
	}
}
