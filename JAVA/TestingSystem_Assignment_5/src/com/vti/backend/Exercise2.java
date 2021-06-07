package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.HinhChuNhat;
import com.vti.entity.HinhVuong;
import com.vti.entity.Student2;

public class Exercise2 {
	public void Question1() {
		ArrayList<Student2> liststd = new ArrayList<Student2>();
		for(int i = 0; i < 11; i++) {
			int y = i;
			if(i%2 == 0) y++;
			else y--;
			Student2 std = new Student2("Nguyễn Văn " + i,y);
			liststd.add(std);
		}
		for(Student2 std2 : liststd) {
			System.out.println(std2.toString());
		}
		for(Student2 std2 : liststd) {
			if(std2.getGroup() == 1)
				std2.DiemDanh();
		}
		for(Student2 std2 : liststd) {
			if(std2.getGroup() == 2)
				std2.DonVS();
		}
	}
	public void Question3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("mời nhập cạnh hình vuông(cm): ");
		HinhVuong hv = new HinhVuong(sc.nextFloat());
		System.out.println("chu vi hình vuông: " + hv.TinhChuVi() + "cm");
		System.out.println("diện tích hình vuông: " + hv.TinhDienTich() + "cm^2");
	}
}
