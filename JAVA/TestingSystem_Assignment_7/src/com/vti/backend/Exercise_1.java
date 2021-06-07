package com.vti.backend;

import java.util.ArrayList;

import com.vti.entity.HinhChuNhat;
import com.vti.entity.HinhHoc;
import com.vti.entity.PrimartStuden;
import com.vti.entity.SecondaryStudent;
import com.vti.entity.Student;

public class Exercise_1 {
	public void Question_1() {
		
		Student std1 = new Student();
		Student std2 = new Student();
		Student std3 = new Student();
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
		Student std1 = new Student();
		Student std2 = new Student();
		Student std3 = new Student();
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
	public void question_4() {
		Student std = new Student();
		std.setName("Nguyễn tiến anh");
		System.out.println("trường đại học của "+std.getName() + "là: " + std.getCollege());
		std.setCollege("Đại học chữ to");
		System.out.println("trường đại học của "+std.getName() + "là: " + std.getCollege());
		
	}
	public void Question_5() {
		Student std1 = new Student();
		Student std2 = new Student();
		Student std3 = new Student();
		ArrayList<Student> liststd = new ArrayList<Student>();
		liststd.add(std1);
		liststd.add(std2);
		liststd.add(std3);
		Student std = new Student();
		int Count = std.getCount() + 1;
		System.out.println("số lượng student được tạo ra là: " + std.getCount());
	}
	public void Question_6_7() {
		Student std1 = new SecondaryStudent();
		Student std2 = new PrimartStuden();
		Student std3 = new SecondaryStudent();
		Student std4 = new SecondaryStudent();
		Student std5 = new PrimartStuden();
		Student std6 = new SecondaryStudent();
		Student std7 = new PrimartStuden();
		Student std8 = new SecondaryStudent();
		System.out.println("số học sinh primary: "+ PrimartStuden.COUNTpr);
		System.out.println("số học sinh primary: "+ SecondaryStudent.COUNTse);
	}
	public void Question_8() throws Exception {
		HinhHoc h1 = new HinhChuNhat(1, 2);
		HinhHoc h2 = new HinhChuNhat(1, 2);
		HinhHoc h3 = new HinhChuNhat(1, 2);
		HinhHoc h4 = new HinhChuNhat(1, 2);
		HinhHoc h5 = new HinhChuNhat(1, 2);
		System.out.println("5 hình");
		HinhHoc h6 = new HinhChuNhat(1, 2);
		HinhHoc h7 = new HinhChuNhat(1, 2);
		
	}
}
