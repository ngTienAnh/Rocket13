package com.vti.backend;

import java.util.ArrayList;

import com.vti.entity.Student;

public class Exercise_1 {
	public void Question_1() {
		
		Student std1 = new Student("Nguyễn văn a");
		Student std2 = new Student("Nguyễn văn b");
		Student std3 = new Student("Nguyễn văn c");
		ArrayList<Student> liststd = new ArrayList<Student>();
		liststd.add(std1);
		liststd.add(std2);
		liststd.add(std3);
		
		for(Student std : liststd) {
			System.out.println(std.toString());
		}
		
		std1.setCollege("Mở hà nội");
		
		for(Student std : liststd) {
			System.out.println(std.toString());
		}
	}
	public void Question_2() {
		Student std1 = new Student("Nguyễn văn a");
		Student std2 = new Student("Nguyễn văn b");
		Student std3 = new Student("Nguyễn văn c");
		ArrayList<Student> liststd = new ArrayList<Student>();
		liststd.add(std1);
		liststd.add(std2);
		liststd.add(std3);
		
		for(Student std : liststd) {
			std.setMoneyGroup(100);
		}
		std1.setMoneyGroup(-50);
		std1.setMoneyGroup(-20);
		std1.setMoneyGroup(-150);
		for(Student std : liststd) {
			std.setMoneyGroup(50);
		}
	}
	public void Question_5() {
		Student std1 = new Student("Nguyễn văn a");
		Student std2 = new Student("Nguyễn văn b");
		Student std3 = new Student("Nguyễn văn c");
		ArrayList<Student> liststd = new ArrayList<Student>();
		liststd.add(std1);
		liststd.add(std2);
		liststd.add(std3);
		Student std = new Student();
		int Count = std.getCount() + 1;
		System.out.println("số lượng student được tạo ra là: " + std.getCount());
	}
	public void Question_6() {
		Student std1 = new Student("Nguyễn văn a");
		Student std2 = new Student("Nguyễn văn b");
		Student std3 = new Student("Nguyễn văn c");
		
	}
}
