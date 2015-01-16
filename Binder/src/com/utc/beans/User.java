package com.utc.beans;

import java.util.HashSet;
import java.util.Set;


public class User {
	private Long  userId;
	private String email;
	private String password;
	private String username;
	private String addresse;
	private String telephone;
	private String   creation_date;
	private String status;
	private Set<Roles> roles=new HashSet(); 
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Set<Roles> getRoles() {
		return roles;
	}
	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	public Long  getUserId() {
		return userId;
	}
	public void setUserId(Long  userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String address) {
		this.addresse = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String  getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(String  creation_date) {
		this.creation_date = creation_date;
	}
	
	
	
	public User(Long userId, String email, String password, String username,
			String addresse, String telephone, String creation_date,
			Set<Roles> roles) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.username = username;
		this.addresse = addresse;
		this.telephone = telephone;
		this.creation_date = creation_date;
		this.roles = roles;
	}
	public User() {
		super();
	}
	
	
}
