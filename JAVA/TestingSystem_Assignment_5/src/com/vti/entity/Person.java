package com.vti.entity;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Person {
	private String name;
	private String add;
	private LocalDate dateBird;
	private Gender gender;
	
	public enum Gender{
		Male, Female, Unknow;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public LocalDate getDateBird() {
		return dateBird;
	}

	public void setDateBird(LocalDate dateBird) {
		this.dateBird = dateBird;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Person(String name, String add, LocalDate dateBird, Gender gender) {
		super();
		this.name = name;
		this.add = add;
		this.dateBird = dateBird;
		this.gender = gender;
	}

	public Person() {
		super();
	}
	
	public void InputInfor() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Name: ");
		this.name = sc.next();
		System.out.println("Add");
		this.add = sc.next();
		System.out.println("DateBird");
		this.dateBird = LocalDate.parse(sc.next());
		System.out.println("1.Male, 2.Female, 3.Unknow");
		int select = sc.nextInt();
		if(select == 1) this.gender = Gender.Male;
		else if(select == 2) this.gender = gender.Female;
		else this.gender = gender.Unknow;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", add=" + add + ", dateBird=" + dateBird + ", gender=" + gender + "]";
	}
	
	public void showInfor() {
		System.out.println(this.toString());
		
	}
}
