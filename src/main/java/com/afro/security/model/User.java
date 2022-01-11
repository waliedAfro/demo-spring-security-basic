package com.afro.security.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId ; 
	private String userName ;
	private String password ;
	private String role ; 
	private boolean status ;
	
	
	public long getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getRole() {
		return role;
	}
	public boolean isStatus() {
		return status;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 
	

}
