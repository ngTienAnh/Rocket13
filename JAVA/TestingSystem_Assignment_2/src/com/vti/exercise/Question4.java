package com.vti.exercise;

import com.vti.entity.Account;

public class Question4 {
	public void checkDev(Account acc) {
		System.out.println(acc.position.Name.toString() == "Dev"? 
				"Đây là Developer" : "Đây không phải Developer");	
	}
}
