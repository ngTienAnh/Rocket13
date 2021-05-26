package com.vti.exercise1;

import com.vti.entity.Account;

public class Question1 {
	public void checkDepartment(Account acc) {
		if (acc.department == null)
			System.out.println("Nhân viên này chưa có phòng ban");
		else
			System.out.println("Phòng ban của nhân viên này là: " + acc.department.Name);
	}
}
