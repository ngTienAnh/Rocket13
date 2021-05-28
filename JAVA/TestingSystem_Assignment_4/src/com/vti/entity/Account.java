package com.vti.entity;

import java.time.LocalDate;
import java.util.Arrays;

public class Account {
	private int ID;
	private String email;
	private String userName;
	private String fullName;
	private Position position;
	private Department department;
	private LocalDate creatdate;
	private Group[] group;
	
	public Account(int iD, String email, String userName, String fullName, Position position, Department department,
			LocalDate creatdate, Group[] group) {
		super();
		ID = iD;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.position = position;
		this.department = department;
		this.creatdate = creatdate;
		this.group = group;
	}

	public Account() {
		super();
	}
	
	public Account(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Account [ID=" + ID + ", email=" + email + ", userName=" + userName + ", fullName=" + fullName
				+ ", position=" + position + ", department=" + department + ", creatdate=" + creatdate + ", group="
				+ Arrays.toString(group) + "]";
	}
	
	public Account(int iD, String email, String userName, String firstName, String lastName) {
		super();
		ID = iD;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + lastName;
	}
	
	public Account(int iD, String email, String userName, String firstName, String lastName,Position position, LocalDate creatdate) {
		super();
		ID = iD;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + lastName;
		this.position = position;
		this.creatdate = creatdate;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public LocalDate getCreatdate() {
		return creatdate;
	}

	public void setCreatdate(LocalDate creatdate) {
		this.creatdate = creatdate;
	}

	public Group[] getGroup() {
		return group;
	}

	public void setGroup(Group[] group) {
		this.group = group;
	}
	}
