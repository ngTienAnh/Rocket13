package com.vti.backend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PosititionName;

public class Exercise_1 {

	public void Question1(){
		Department exe1 = new Department();
		Department exe2 = new Department("Tiến Anh");
	}
	
	public void Question2() {
		Account account1 = new Account();
		Account account2 = new Account(1, "abc@gmail.com", "userName1", "firstName", "lastName");
		Position pos1 = new Position(1,PosititionName.DEV);
		Account account3 = new Account(1, "abc@gmail.com", "userName1", "firstName", "lastName", pos1, LocalDate.of(2021,05,05));
	}
	
	public void Question3() {
		Group gr = new Group();
		String acc[] = {"anh","em","co"};
		Group gr2 = new Group("name", 1, LocalDate.of(2021,05,05) , acc);
	}
}
