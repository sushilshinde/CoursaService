package com.coursa.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Student implements Serializable {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private long id;	
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="coursa_id")
	private long coursaId;
	
	public long getCoursaId() {
		return coursaId;
	}
	public void setCoursaId(long coursaId) {
		this.coursaId = coursaId;
	}
	
	@Transient
	private String userNameEmail;
	
	@Transient
	private String password;
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserNameEmail() {
		return userNameEmail;
	}
	public void setUserNameEmail(String userNameEmail) {
		this.userNameEmail = userNameEmail;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {		
		return this.id + ", " +  this.firstName + ", " + this.lastName + ", " + this.userNameEmail+ ", " + this.password + ", "+ this.coursaId;
	}
}
