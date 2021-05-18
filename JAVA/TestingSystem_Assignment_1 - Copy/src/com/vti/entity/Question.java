package com.vti.entity;

import java.time.LocalDate;

public class Question {
	public int ID;
	public String Content;
	public Category Category;
	public TypeQuestion Type;
	public Account Creator;
	public LocalDate CreateDate;
	public Answer Answer[];
	public Exam Exam[];
}
