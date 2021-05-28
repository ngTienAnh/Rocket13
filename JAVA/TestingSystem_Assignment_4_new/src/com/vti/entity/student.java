package com.vti.entity;

public abstract class student extends person {
	private int id;
	
	public student(String name, int id) {
		super(name);
		this.id = id;
	}	
}
