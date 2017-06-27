package com.coursa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="universities")
public class University  implements Serializable {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="alpha_two_code")
	private String alphaTwoCode;
	
	@Column(name="country")	
	private String country;
	
	@Column(name="domain")
	private String domain;
	
	@Column(name="name")
	private String name;
	
	@Column(name="web_page")
	private String webpage;
	
	@Column(name="coursa_id")
	private long coursaId;	
	
	@Transient
	private String userNameEmail;
	
	@Transient
	private String password;
	
		
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
	public long getCoursaId() {
		return coursaId;
	}
	public void setCoursaId(long coursaId) {
		this.coursaId = coursaId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAlphaTwoCode() {
		return alphaTwoCode;
	}
	public void setAlphaTwoCode(String alphaTwoCode) {
		this.alphaTwoCode = alphaTwoCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebpage() {
		return webpage;
	}
	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}
	
	@Override
	public String toString() {		
		return this.id + ", " +  this.alphaTwoCode + ", " + this.country + ", " + this.domain +", " +  this.name+", " +  this.webpage  ;
	}
}
