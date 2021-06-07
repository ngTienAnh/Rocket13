package com.vti.backend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import com.vti.entity.Student;
import com.vti.ultis.ScannerUltis;

public class Exerise1 {
	private ArrayList<Student> ListStd;
	private Scanner sc;

	public Exerise1() {
		super();
		ListStd = new ArrayList<Student>();
		sc = new Scanner(System.in);
	}

	public void ques1() {
		for (int i = 1; i < 11; i++) {
			Student std = new Student("Nguyễn văn " + i);
			ListStd.add(std);
		}
		System.out.println("Tổng số sinh viên: " + Student.COUNT);
		System.out.println("thông tin sinh viên thứ 4: " + ListStd.get(3).toString());
		System.out.println("thông tin sinh viên đầu tiên: " + ListStd.get(0).toString());
		System.out.println("thông tin sinh viên cuối cùng: " + ListStd.get(ListStd.size() - 1).toString());
		ListStd.add(0, new Student("Nguyễn Tiến Anh"));
		ListStd.add(new Student("Nguyễn Tiến Em"));
		Collections.reverse(ListStd);
		for (Student std : ListStd) {
			System.out.println(std.toString());
		}
	}

	public void timStudent_ID() {
		System.out.println("Mời nhập ID cần tìm: ");
		int find = ScannerUltis.inputInt();
		for (Student std : ListStd) {
			if (std.getId() == find)
				System.out.println(std.toString());
		}
	}

	public void timStudent_Name() {
		System.out.println("Mời nhập tên cần tìm: ");
		String find = ScannerUltis.inputString();
		for (Student std : ListStd) {
			if (std.getName() == find)
				System.out.println(std.toString());
		}
	}

	public void TimStuden_SameName() {
		for(int i = 0; i < ListStd.size(); i++) {
			Student stdx = ListStd.get(i);
			for(Student std : ListStd) {
				if(stdx.getName() == std.getName())
					System.out.println(std.toString());
			}
		}
	}
	public void XoaName() {
		for(Student std : ListStd) {
			if(std.getId() == 2)
				std.setName( null);
		}
	}
	public void XoaStu() {
		for(Student std : ListStd) {
			if(std.getId() == 5)
				ListStd.remove(std);
		}
	}
	public void DoubleStudent() {
		ArrayList<Student> listCoppy = new ArrayList<Student>();
		listCoppy.addAll(ListStd);
	}
}
