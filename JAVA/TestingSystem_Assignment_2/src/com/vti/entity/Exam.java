package com.vti.entity;

import java.time.LocalDate;

public class Exam {
	public int ID;
	public String Code;
	public String Title;
	public Category Category;
	public int Duration;
	public Account Creator;
	public LocalDate CreateDate;
	public Question Question[];
}
