package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weddings")
public class Wedding {

	@Id
	@Column(name = "weddingid")
	private String weddingId;

	@Column(name = "weddingname")
	private String weddingName;

	@Column(name = "weddingdate")
	private String weddingDate;

	@Column(name = "budget")
	private double budget;

	@Column(name = "venueid")
	private String venueId;

	@Column(name = "floristid")
	private String flortistId;

	@Column(name = "catererid")
	private String catererId;

	@Column(name = "musicianid")
	private String musicianId;

	@Column(name = "photographid")
	private String photographId;

	public Wedding() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wedding(String weddingId, String weddingName, String weddingDate, double budget, String venueId,
			String flortistId, String catererId, String musicianId, String photographId) {
		super();
		this.weddingId = weddingId;
		this.weddingName = weddingName;
		this.weddingDate = weddingDate;
		this.budget = budget;
		this.venueId = venueId;
		this.flortistId = flortistId;
		this.catererId = catererId;
		this.musicianId = musicianId;
		this.photographId = photographId;
	}

	public Wedding(String weddingId) {
		super();
		this.weddingId = weddingId;
	}

	public String getWeddingId() {
		return weddingId;
	}

	public void setWeddingId(String weddingId) {
		this.weddingId = weddingId;
	}

	public String getWeddingName() {
		return weddingName;
	}

	public void setWeddingName(String weddingName) {
		this.weddingName = weddingName;
	}

	public String getWeddingDate() {
		return weddingDate;
	}

	public void setWeddingDate(String weddingDate) {
		this.weddingDate = weddingDate;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public String getVenueId() {
		return venueId;
	}

	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}

	public String getFlortistId() {
		return flortistId;
	}

	public void setFlortistId(String flortistId) {
		this.flortistId = flortistId;
	}

	public String getCatererId() {
		return catererId;
	}

	public void setCatererId(String catererId) {
		this.catererId = catererId;
	}

	public String getMusicianId() {
		return musicianId;
	}

	public void setMusicianId(String musicianId) {
		this.musicianId = musicianId;
	}

	public String getPhotographId() {
		return photographId;
	}

	public void setPhotographId(String photographId) {
		this.photographId = photographId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(budget, catererId, flortistId, musicianId, photographId, venueId, weddingDate, weddingId,
				weddingName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wedding other = (Wedding) obj;
		return Double.doubleToLongBits(budget) == Double.doubleToLongBits(other.budget)
				&& Objects.equals(catererId, other.catererId) && Objects.equals(flortistId, other.flortistId)
				&& Objects.equals(musicianId, other.musicianId) && Objects.equals(photographId, other.photographId)
				&& Objects.equals(venueId, other.venueId) && Objects.equals(weddingDate, other.weddingDate)
				&& Objects.equals(weddingId, other.weddingId) && Objects.equals(weddingName, other.weddingName);
	}

	@Override
	public String toString() {
		return "Wedding [weddingId=" + weddingId + ", weddingName=" + weddingName + ", weddingDate=" + weddingDate
				+ ", budget=" + budget + ", venueId=" + venueId + ", flortistId=" + flortistId + ", catererId="
				+ catererId + ", musicianId=" + musicianId + ", photographId=" + photographId + "]";
	}

}
