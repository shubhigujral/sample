package com.amazonCustomer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="amazoncustomer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //ignores garbage created by hibernate
public class AmazonCustomer {

	@Id
	@GeneratedValue
	private int id;
	@Column
	private String name;
	@Column
	private String email;
	
	public AmazonCustomer(int id, String name, String email) {
		
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public AmazonCustomer() {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
