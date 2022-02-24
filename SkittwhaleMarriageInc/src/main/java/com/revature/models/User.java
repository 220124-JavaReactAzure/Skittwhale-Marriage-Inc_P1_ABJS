package com.revature.models;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="userid", updatable = false, nullable = false, columnDefinition = "VARCHAR")
	@Type(type = "uuid-char")
	private UUID id;

	@Column(name="username")
	private String username;

	@Column(name="userpassword")
	private String password;

	@Column(name="email", unique = true)
	private String email;

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

	public User(UUID id, String username, String userpassword, String email, boolean plusone, int mealid,
			int plusonemealid, int usertypeid, String weddingid) {
		super();
		this.id = id;
		this.username = username;
		this.password = userpassword;
		this.email = email;
		this.plusone = plusone;
		this.mealid = mealid;
		this.plusonemealid = plusonemealid;
		this.usertypeid = usertypeid;
		this.weddingid = weddingid;
	}

	public User(String username, String password, String email, boolean plusone, int mealid, int plusonemealid,
			int usertypeid, String weddingid) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.plusone = plusone;
		this.mealid = mealid;
		this.plusonemealid = plusonemealid;
		this.usertypeid = usertypeid;
		this.weddingid = weddingid;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return "User [username=" + username + ", userpassword=" + password + ", email=" + email + ", plusone="
				+ plusone + ", mealid=" + mealid + ", plusonemealid=" + plusonemealid + ", usertypeid=" + usertypeid
				+ ", weddingid=" + weddingid + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, mealid, password, plusone, plusonemealid, username, usertypeid, weddingid);
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
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && mealid == other.mealid
				&& Objects.equals(password, other.password) && plusone == other.plusone
				&& plusonemealid == other.plusonemealid && Objects.equals(username, other.username)
				&& usertypeid == other.usertypeid && Objects.equals(weddingid, other.weddingid);
	}
	

}
