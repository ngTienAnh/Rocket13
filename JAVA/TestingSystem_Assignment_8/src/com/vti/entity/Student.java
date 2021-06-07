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
	
	
}
