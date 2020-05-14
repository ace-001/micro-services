package com.cg.hcs.patient.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users 
{
	@Id
	@Column(name = "user_id")
	private String user_id;
	@Column(name = "user_name")
	private String user_name;
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	private  String role ;
	
	public Users() {}

	public Users(String user_id, String user_name, String password, String role) 
	{
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.role = role;
	}

	public String getUser_id() 
	{
		return user_id;
	}

	public void setUser_id(String user_id) 
	{
		this.user_id = user_id;
	}

	public String getUser_name() 
	{
		return user_name;
	}

	public void setUser_name(String user_name) 
	{
		this.user_name = user_name;
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

	public void setRole(String role) 
	{
		this.role = role;
	}	
}
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
