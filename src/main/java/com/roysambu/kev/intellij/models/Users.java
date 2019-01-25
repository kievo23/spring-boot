package com.roysambu.kev.intellij.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Users {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String phone;
	private String testosterone;
	
	public Users() {
		
	}
	public Users(Integer id, String name, String phone, String testosterone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.testosterone = testosterone;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTestosterone() {
		return testosterone;
	}
	public void setTestosterone(String testosterone) {
		this.testosterone = testosterone;
	}
	
}
