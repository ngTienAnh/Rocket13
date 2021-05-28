package com.vti.entity;

public abstract class  person {
	private String name;

	
	
	public person(String name) {
		super();
		this.name = name;
	}


	public person() {
		super();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "person [name=" + name + "]";
	}
	
	
}
