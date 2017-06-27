package com.coursa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_roles")
public class UserRole {	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private long id;	
	
	@Column(name="user_id")
	private long userId;
	
	@Column(name="role_id")
	private long roleId;

	public long getId() {
		return id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public void setId(long id) {
		this.id = id;
	}

}
