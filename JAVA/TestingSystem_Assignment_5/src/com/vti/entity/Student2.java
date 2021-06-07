package com.vti.entity;

public class Student2 implements IStudent {
	private int ID;
	private String Name;
	private int Group;
	private static int COUNT = 0;
	
	public Student2(String name, int group) {
		super();
		Name = name;
		Group = group;
		ID = COUNT++;
	}
	
	@Override
	public void HocBai() {
		// TODO Auto-generated method stub
		System.out.println(this.Name + "học bài");
		
	}
	@Override
	public void DiemDanh() {
		// TODO Auto-generated method stub
		System.out.println(this.Name + "điểm danh");
		
	}
	@Override
	public void DonVS() {
		// TODO Auto-generated method stub
		System.out.println(this.Name + "đi dọn vệ sinh");
	}

	@Override
	public String toString() {
		return "Student2 [ID=" + ID + ", Name=" + Name + ", Group=" + Group + "]";
	}

	public int getGroup() {
		return Group;
	}
	
}
