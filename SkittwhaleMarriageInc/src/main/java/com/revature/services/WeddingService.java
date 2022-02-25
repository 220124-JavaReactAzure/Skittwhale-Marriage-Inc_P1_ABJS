package com.revature.services;

import java.util.List;

import com.revature.dao.WeddingDAO;
import com.revature.models.Wedding;



public class WeddingService {
	private final WeddingDAO weddingDAO;
	
	public WeddingService(WeddingDAO weddingDAO) {
		this.weddingDAO= weddingDAO;
	}
	
	public boolean addWedding(Wedding wedding) {
		return weddingDAO.addWedding(wedding);
	}
	
	public List<Wedding> getAllWeddings(){
		return weddingDAO.getAllWeddings();
	}
	
	//will probably be string since uuid
	public Wedding getUserById(String id) {
		return weddingDAO.findByWeddingId(id);
	}
	
	public void updateWeddingWithSessionMethod(Wedding wedding) {
		weddingDAO.updateWeddingWithSessionMethod(wedding);
	}
	
	public void updateWeddingWithHQL(Wedding wedding) {
		weddingDAO.updateWeddingWithHQL(wedding);
	}
}
