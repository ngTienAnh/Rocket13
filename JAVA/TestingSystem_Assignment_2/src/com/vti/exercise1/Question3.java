package com.vti.exercise1;

import com.vti.entity.Account;

public class Question3 {
	public void checkDepartmentTenary(Account acc) {
		System.out.println(acc.department == null ? "Nhân viên này chưa có phòng ban"
				: "Group của nhân viên này là " + acc.group[0].Name + " Fresher " + acc.group[1].Name + " Fresher ");
	}
}
