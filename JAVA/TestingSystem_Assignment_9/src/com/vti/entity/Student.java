package com.vti.entity;

import java.util.Scanner;

public class Student {
	private int id;
	private String name;

	public static int COUNT = 0;

	public Student(String name) {
		super();
		this.name = name;
		this.id = COUNT++;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	@Deprecated
	public int getId() {
		return id;
	}
	public String getIdWithMSV() {
		return "MSV" +id;
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
	
	
}
