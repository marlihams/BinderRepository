package com.utc.beans;

public class Roles {
	private Long roleId;
	private String role;
	
	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Roles(Long roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}
