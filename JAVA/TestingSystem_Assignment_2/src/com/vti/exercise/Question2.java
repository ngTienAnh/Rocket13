package com.vti.exercise;

import com.vti.entity.Account;

public class Question2 {
	public void checkGroup(Account acc) {
		if (acc.group == null)
			System.out.println("Nhân viên này chưa có group");
		else if (acc.group.length == 2)
			System.out.println(
					"Group của nhân viên này là " + acc.group[0].Name + " Fresher " + acc.group[1].Name + " Fresher ");
		else if (acc.group.length == 3)
			System.out.println("Nhân viên này là người quan trọng ,tham gia nhiều group");
		else
			System.out.println("Nhân viên này là người nhiều chuyện, tham gia rất nhiều group");
	}
}
