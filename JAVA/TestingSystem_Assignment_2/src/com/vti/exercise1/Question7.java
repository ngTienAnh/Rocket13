package com.vti.exercise1;

import com.vti.entity.Account;

public class Question7 {
	public void checkDev(Account acc) {
		switch (acc.position.Name.toString()) {
		case "DEV":
			System.out.println("�?ây là Developer");
			break;
		default:
			System.out.println("�?ây không phải Developer");
		}
	}
}