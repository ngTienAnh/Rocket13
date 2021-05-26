package com.vti.exercise1;

import com.vti.entity.Account;

public class Question10 {
	public void listAccount(Account acc[]) {
		for (int i = 0; i < acc.length; i++) {
			printAccount(acc[i], i);
		}
	}

	public void printAccount(Account acc, int i) {
		System.out.println("\nThông tin account thứ " + i + "là: ");
		System.out.println("Email: " + acc.email);
		System.out.println("Fullname: " + acc.fullName);
		System.out.println("Department: " + acc.department.Name);
	}
}
