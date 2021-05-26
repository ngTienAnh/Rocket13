package com.vti.backend;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import com.vti.entity.Category;
import com.vti.entity.Exam;


public class Exercise3 {
	public static void main(String[] args) {
		Category category1 = new Category();
		category1.ID = 1;
		category1.Category = "caca";
		
		Exam exam1 = new Exam();
		exam1.Category = category1;
		exam1.Code = "ex2";
		
		question1(exam1);
	}
	public static void question1(Exam exam) {
		Locale localde = new Locale("vn","VN");
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT,localde);
		String date = dateFormat.format(exam.CreateDate);
		System.out.println(exam.Title + " " + date);
	}
	public static void question2(Exam exam) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd-HH-mm-ss");
		System.out.println(exam.Title + " " + simpleDateFormat.format(exam.CreateDate));
	}
	public static void question3(Exam exam) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
		System.out.println(exam.Title + " " + simpleDateFormat.format(exam.CreateDate));
	}
	public static void question4(Exam exam) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-yyyy");
		System.out.println(exam.Title + " " + simpleDateFormat.format(exam.CreateDate));
	}
	public static void question5(Exam exam) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
		System.out.println(exam.Title + " " + simpleDateFormat.format(exam.CreateDate));
	}
}
