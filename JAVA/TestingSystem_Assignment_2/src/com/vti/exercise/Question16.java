package com.vti.exercise;

import com.vti.entity.Account;
import com.vti.entity.Department;

public class Question16 {
	public void remakeQues10(Account Acc[]) {
		Question10 ques10 = new Question10();
		int i = 0;
		while (i < Acc.length) {
			ques10.printAccount(Acc[i], i);
			i++;
		}
	}

	public void remakeQues11(Department Dep[]) {
		Question11 ques11 = new Question11();
		int i = 0;
		while (i < Dep.length) {
			ques11.printDepartment(Dep[i], i);
			i++;
		}
	}

	public void remakeQues12(Department Dep[]) {
		Question11 ques11 = new Question11();
		int i = 0;
		while (i < 2) {
			ques11.printDepartment(Dep[i], i);
			i++;
		}
	}

	public void remakeQues13(Account Acc[]) {
		Question10 ques10 = new Question10();
		int i = 0;
		while (i < Acc.length) {
			if (i == 2)
				continue;
			else
				ques10.printAccount(Acc[i], i);
			i++;
		}
	}

	public void remakeQues14(Account Acc[]) {
		Question10 ques10 = new Question10();
		int i = 0;
		while (i < Acc.length) {
			if (Acc[i].ID > 3)
				continue;
			else
				ques10.printAccount(Acc[i], i);
			i++;
		}
	}

	public void remakeQues15() {
		int i = 20;
		while (i >= 0) {
			System.out.println("\t" + i);
			i -= 2;
		}
	}
}
