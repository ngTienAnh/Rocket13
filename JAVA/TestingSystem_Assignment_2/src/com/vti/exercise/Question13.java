package com.vti.exercise;

import com.vti.entity.Account;

public class Question13 {
	public void listAccount(Account Acc[]) {
		Question10 ques10 = new Question10();
		for (int i = 0; i < Acc.length; i++) {
			if (i != 2) {
				ques10.printAccount(Acc[i], i);
			}
		}
	}
}
