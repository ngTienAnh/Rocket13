package com.vti.entity;

public class contact {
	private String phone;
	private String name;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public contact(String phone, String name) {
		super();
		this.phone = phone;
		this.name = name;
	}
	public contact() {
		super();
	}

	
}	
