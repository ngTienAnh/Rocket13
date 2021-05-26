package com.vti.exercise1;

import com.vti.entity.Account;

public class Question14 {
	public void listAccountIdBelow4(Account Acc[]) {
		Question10 ques10 = new Question10();
		for (int i = 0; Acc[i].ID < 4; i++) {
			ques10.printAccount(Acc[i], i);
		}
	}
}
