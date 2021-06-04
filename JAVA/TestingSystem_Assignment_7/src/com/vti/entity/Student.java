package com.vti.entity;

public class Student {
	private int id;
	private String name;
	private static String college = "Đại học bách khoa";
	private static int moneyGroup = 0;
	private static int count = 0; 
	public Student() {
		super();
	}
	
	public Student ( String name) {
		this.id = count++;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", college =" + college + "]";
	}

	public static String getCollege() {
		return college;
	}

	public static void setCollege(String college) {
		Student.college = college;
	}

	public static int getMoneyGroup() {
		return moneyGroup;
	}

	public static void setMoneyGroup(int moneyGroup) {
		Student.moneyGroup += moneyGroup;
		System.out.println("Tổng quỹ: " + Student.moneyGroup);
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Student.count = count;
	}
}
