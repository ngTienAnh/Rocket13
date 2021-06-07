package com.vti.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class TuyenSinh implements ITuyenSinh {
	private Scanner sc;
	private ArrayList<Student> listStudent;

	public TuyenSinh() {
		sc = new Scanner(System.in);
		listStudent = new ArrayList<Student>();
	}

	@Override
	public void Insert() {
		// TODO Auto-generated method stub
		Student std = new Student();
		ClassSub sb = new ClassSub();
		System.out.println("\tMời nhập tên: ");
		std.setName(sc.next());
		System.out.println("\tMời nhập địa chỉ: ");
		std.setAdd(sc.next());
		System.out.println("\tMời nhập ưu tiên: ");
		std.setPriaty(sc.next());
		System.out.println(sb.toString());
		System.out.println("Mời chọn khối:");
		String choose = sc.next();
		for(ClassSubject sl : sb.listClass) {
			if(sl.getID() == choose) {
				std.setClass(sl);
				break;
			}
		}
		listStudent.add(std);
	}

	@Override
	public void Display() {
		// TODO Auto-generated method stub
		for (Student std : listStudent) {
			System.out.println(std.toString());
		}
	}

	@Override
	public void Search() {
		// TODO Auto-generated method stub
		System.out.println("Mời nhập số báo danh cần tìm: ");
		for (Student std : listStudent) {
			if (sc.nextInt() == std.getID()) {
				System.out.println(std.toString());
			}
		}
	}

}
