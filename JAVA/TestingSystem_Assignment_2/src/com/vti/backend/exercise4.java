package com.vti.backend;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Random;


public class exercise4 {
	public static void question1() {
		Random random = new Random();
		System.out.println("số nguyên ngẫu nhiên là: "+random.nextInt());
	}
	public static void question2() {
		Random random = new Random();
		System.out.println("số nguyên ngẫu nhiên là: "+random.nextFloat());
	}
	public static void question3() {
		String ten[] = {"trung","nam","duy"};
		Random random = new Random();
		System.out.println("số nguyên ngẫu nhiên là: "+random.nextInt(ten.length));
	}
	public static void question4() {
		int minDay = (int) LocalDate.of(1995,7,24).toEpochDay();
		int maxDay = (int) LocalDate.of(1995,12,20).toEpochDay();
		Random random = new Random();
		LocalDate ranDay = LocalDate.ofEpochDay(minDay + random.nextInt(maxDay - minDay));
		System.out.println(ranDay);
	}
	public static void question5() {
		int minDay = (int) LocalDate.of(1995,7,24).toEpochDay();
		int maxDay = (int) LocalDate.of(1995,12,20).toEpochDay();
		Random random = new Random();
		LocalDate ranDay = LocalDate.ofEpochDay(minDay + random.nextInt(maxDay - minDay));
		System.out.println(ranDay);
	}
}
