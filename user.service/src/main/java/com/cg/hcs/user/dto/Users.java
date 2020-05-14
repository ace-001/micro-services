package com.cg.hcs.user.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.ManyToOne;
@Entity
@Table(name="users")
public class Users 
{
	@Id
	@Column(name = "user_id")
	private String userId;
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	private String role = "";
	
	public Users(String userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Users() {}

	public String getUserId() 
	{
		return userId;
	}
	public void setUserId(String userId) 
	{
		this.userId = userId;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getRole() 
	{
		return role;
	}
}
