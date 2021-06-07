package com.vti.entity;

import java.util.Scanner;

public class Student3 extends Person {
	private int ID;
	private float GPA;
	private String Email;
	private static int COUNT = 0;
	
	@Override
	public void InputInfor() {
		super.InputInfor();
		Scanner sc = new Scanner(System.in);
		ID = COUNT++;
		System.out.println("GPA: ");
		GPA = sc.nextFloat();
		System.out.println("Email: ");
		Email = sc.next();
	}
	
	
	@Override
	public String toString() {
		return "ID=" + ID + ", GPA=" + GPA + ", Email=" + Email + "]";
	}


	@Override
	public void showInfor() {
		System.out.printf(this.toString());
		super.showInfor();
	}
	public void rickOrPoor() {
		System.out.println(GPA > 8.0 ? "you are rick" :"poor af");
	}
}
