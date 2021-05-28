package com.vti.entity;

public class HighSchoolStudent extends student {
	private String Class;
	private String desiredUniversity;
	
	public HighSchoolStudent(String name, int id, String class1, String desiredUniversity) {
		super(name, id);
		Class = class1;
		this.desiredUniversity = desiredUniversity;
	}
}
