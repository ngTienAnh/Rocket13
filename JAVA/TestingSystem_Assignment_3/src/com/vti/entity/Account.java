package com.vti.entity;

import java.time.LocalDate;

public class Account {
	public int ID; 
	public String email;
	public String userName;
	public String fullName;
	public Position position;
	public Department department;
	public LocalDate creatdate;
	public Group[] group;
}

