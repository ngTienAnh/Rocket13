package com.vti.exercise1;

import com.vti.entity.Account;
import com.vti.entity.Department;

public class Question17 {
	public void remakeQues10(Account Acc[]) {
		Question10 ques10 = new Question10();
		int i = 0;
		do {
			ques10.printAccount(Acc[i], i);
			i++;
		} while (i < Acc.length);
	}

	public void remakeQues11(Department Dep[]) {
		Question11 ques11 = new Question11();
		int i = 0;
		do {
			ques11.printDepartment(Dep[i], i);
			i++;
		} while (i < Dep.length);
	}

	public void remakeQues12(Department Dep[]) {
		Question11 ques11 = new Question11();
		int i = 0;
		do {
			ques11.printDepartment(Dep[i], i);
			i++;
		} while (i < 2);
	}

	public void remakeQues13(Account Acc[]) {
		Question10 ques10 = new Question10();
		int i = 0;
		do {
			if (i == 2)
				continue;
			else
				ques10.printAccount(Acc[i], i);
			i++;
		} while (i < Acc.length);
	}

	public void remakeQues14(Account Acc[]) {
		Question10 ques10 = new Question10();
		int i = 0;
		do {
			if (Acc[i].ID > 3)
				continue;
			else
				ques10.printAccount(Acc[i], i);
			i++;
		} while (i < Acc.length);
	}

	public void remakeQues15() {
		int i = 20;
		do {
			System.out.println("\t" + i);
			i -= 2;
		} while (i >= 0);
	}
}