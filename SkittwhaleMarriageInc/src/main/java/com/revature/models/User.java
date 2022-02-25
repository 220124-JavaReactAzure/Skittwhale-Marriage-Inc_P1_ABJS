package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User {

	@Id
	@Column(name="email", unique = true, nullable = false)
	private String email;

	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;

	@Column(name="userpassword")
	private String password;

	@Column(name="plusone")
	private boolean plusone;

	@Column(name="mealid")
	private int mealid;

	@Column(name="plusonemealid")
	private int plusonemealid;

	@Column(name="usertypeid")
	private int usertypeid;

	@Column(name="weddingid")
	private String weddingid;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String email, String firstname, String lastname, String password, boolean plusone, int mealid, int plusonemealid,
			int usertypeid, String weddingid) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.plusone = plusone;
		this.mealid = mealid;
		this.plusonemealid = plusonemealid;
		this.usertypeid = usertypeid;
		this.weddingid = weddingid;
	}
	public User(String email, String password)
	{
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isPlusone() {
		return plusone;
	}

	public void setPlusone(boolean plusone) {
		this.plusone = plusone;
	}

	public int getMealid() {
		return mealid;
	}

	public void setMealid(int mealid) {
		this.mealid = mealid;
	}

	public int getPlusonemealid() {
		return plusonemealid;
	}

	public void setPlusonemealid(int plusonemealid) {
		this.plusonemealid = plusonemealid;
	}

	public int getUsertypeid() {
		return usertypeid;
	}

	public void setUsertypeid(int usertypeid) {
		this.usertypeid = usertypeid;
	}

	public String getWeddingid() {
		return weddingid;
	}

	public void setWeddingid(String weddingid) {
		this.weddingid = weddingid;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", firstname=" + firstname + ", lastname=" + lastname + ", password=" + password
				+ ", plusone=" + plusone + ", mealid=" + mealid + ", plusonemealid=" + plusonemealid + ", usertypeid="
				+ usertypeid + ", weddingid=" + weddingid + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstname, lastname, mealid, password, plusone, plusonemealid, usertypeid,
				weddingid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstname, other.firstname)
				&& Objects.equals(lastname, other.lastname) && mealid == other.mealid
				&& Objects.equals(password, other.password) && plusone == other.plusone
				&& plusonemealid == other.plusonemealid && usertypeid == other.usertypeid
				&& Objects.equals(weddingid, other.weddingid);
	}

}
