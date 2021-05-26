package com.vti.backend;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class exercise2 {
	public static void main(String[] args) {
		Question5();
	}
	public void Question1() {
		System.out.println("Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số nguyên đó");
		int i = 5;
		System.out.println(i);
	}
	
	public static void Question2() {
	System.out.println("Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in\r\n" + 
			"ra số nguyên đó thành định dạng như sau: 100,000,000");
		int i = 1000000000;
		System.out.printf("%,d%n",i);
	}
	
	public static void Question3() {
	System.out.println("Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số\r\n" + 
			"thực đó chỉ bao gồm 4 số đằng sau");
		float f = 5.567098f;
		System.out.printf("%5.4f%n",f);
	}
	public static void Question4() {
	System.out.println("tên x đang độc thân");
		String name = "Nguyễn Bảo Trung";
		System.out.printf("tôi tên là" + name + "tôi đang độc thân");
	}
	public static void Question5() {
	System.out.println("fomat ngày tháng giờ");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(simpleDateFormat.format(new java.util.Date()));
	} 
	public static void Question6() {
	System.out.println("fomat ngày tháng giờ");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(simpleDateFormat.format(new java.util.Date()));
	} 
}
