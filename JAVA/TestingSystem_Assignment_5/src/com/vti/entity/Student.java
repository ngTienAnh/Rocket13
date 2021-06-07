package com.vti.entity;

public class Student {
	private int ID;
	private String Name;
	private String Add;
	private String Priaty;
	private ClassSubject Class;
	public static int COUNT = 0;
	
	public Student(String name, String add, String priaty, ClassSubject class1) {
		super();
		ID = COUNT++;
		Name = name;
		Add = add;
		Priaty = priaty;
		Class = class1;
	}

	public Student() {
		super();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAdd() {
		return Add;
	}

	public void setAdd(String add) {
		Add = add;
	}

	public String getPriaty() {
		return Priaty;
	}

	public void setPriaty(String priaty) {
		Priaty = priaty;
	}

	public void setClass(ClassSubject class1) {
		Class = class1;
	}

	public static int getCOUNT() {
		return COUNT;
	}

	@Override
	public String toString() {
		return "Student [ID=" + ID + ", Name=" + Name + ", Add=" + Add + ", Priaty=" + Priaty + ", Class=" + Class.getID()
		+ ", Block=" + Class.getSubject()
				+ "]";
	}

}
