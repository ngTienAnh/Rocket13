package com.vti.exercise1;

import com.vti.entity.Account;

public class Question6 {
	public void checkAccHasGroup(Account acc) {
		switch (acc.group.length) {
		case 0:
			System.out.println("Nhân viên này chưa có group");
			break;
		case 2:
			System.out.println(
					"Group của nhân viên này là " + acc.group[0].Name + " Fresher " + acc.group[1].Name + " Fresher ");
			break;
		case 3:
			System.out.println("Nhân viên này là ngư�?i quan tr�?ng ,tham gia nhi�?u group");
			break;
		default:
			System.out.println("chưa nghĩ đến");
		}
	}
}
