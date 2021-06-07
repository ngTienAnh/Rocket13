package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Student;

public class Exerise1 {
	private ArrayList<Student> ListStd ;
	private Scanner sc;
	
	
	
	public Exerise1() {
		super();
		ListStd = new ArrayList<Student>();
		sc = new Scanner(System.in);
	}

	public void ques1() {
		for (int i = 1; i < 11; i++) {
			Student std = new Student("Nguyễn văn "+i);
			ListStd.add(std);
		}
		System.out.println("Tổng số sinh viên: "+ Student.COUNT);
		System.out.println("thông tin sinh viên thứ 4: "+ListStd.get(3).toString());
	}
}
