package com.vti.exercise1;

import com.vti.entity.Account;

public class Question8 {
	public void printAccount(Account acc[]) {
		for (Account ac : acc) {
			System.out.println("Fullname: " + ac.fullName);
			System.out.println("Email: " + ac.email);
			System.out.println("Deparment: " + ac.department.Name);
		}
	}
}
