package com.vti.exercise1;

import com.vti.entity.Account;

public class Question4 {
	public void checkDev(Account acc) {
		System.out.println(acc.position.Name.toString() == "Dev"? 
				"�?ây là Developer" : "�?ây không phải Developer");	
	}
}
