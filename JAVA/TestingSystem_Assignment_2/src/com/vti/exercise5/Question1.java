package com.vti.exercise5;

import java.util.Scanner;

public class Question1 {
	public void nhap3SoNguyen (){
		Scanner scanner = new Scanner(System.in);
		int XX[] = null;
		for(int i = 0; i < 3; i++) {
			System.out.println("Mời bạn nhập số thứ " + i +": ");
			XX[i] = scanner.nextInt();
		}
		System.out.println("số đã nhập là: ");
		for(int i = 0; i < XX.length; i++) {
			System.out.print( i + " ,");
		}
	}
}
