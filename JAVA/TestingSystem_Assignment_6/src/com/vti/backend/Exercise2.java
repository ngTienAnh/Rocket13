package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.Department;

public class Exercise2 {
	// Question1
	private static Scanner sc;
	
	public Exercise2() {
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {
		try {
			System.out.println("Kết quả phép chia: " + divie(7, 0));
		} catch (Exception e) {
			System.err.print("không chia được cho 0");
		} finally {// question2
			System.out.println("đã hoàn thành");
		}
	}

	public static float divie(int a, int b) {
		return (float) (a / b);
	}

	public void question3() {
		int[] number = { 1, 2, 3 };
		try {
			System.out.println(number[10]);
		} catch (Exception e) {
			System.out.println("có lỗi sảy ra");
		}
	}

	public void question4() {
		Department department1 = new Department();
		department1.ID = 1;
		department1.Name = "Sale";
		Department department2 = new Department();
		department1.ID = 1;
		department1.Name = "Thư kí";
		Department department3 = new Department();
		department1.ID = 1;
		department1.Name = "Kinh doanh";

		Department[] listdep = { department1, department2, department3 };
		try {
			System.out.println(listdep[10]);
		} catch (Exception e) {
			System.out.println("Không tìm thấy phần tử này trong danh\r\n" + "sách.");
		}
	}

	public int inputAge() {
		while (true) {
			System.out.println("Mời nhập số:");
			try {
				return Integer.parseInt(sc.next().trim());
			} catch (Exception e) {
				System.err.println("không phải số nguyên, mời nhập lại!");
			}
		}
	}
	//ques6
	public static int inputInt2(String err) {
		while (true) {
			try {
				return Integer.parseInt(sc.next().trim());
			} catch (Exception e) {
				System.err.println(err);
			}
		}
	}
}
