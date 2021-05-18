package com.vti.exercise;

import com.vti.entity.Account;

public class Question7 {
	public void checkDev(Account acc) {
		switch (acc.position.Name.toString()) {
		case "DEV":
			System.out.println("Đây là Developer");
			break;
		default:
			System.out.println("Đây không phải Developer");
		}
	}
}