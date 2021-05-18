package com.vti.exercise;

import com.vti.entity.Group;

public class Question5 {
	public void checkGroupNumber(Group group) {
		switch (group.Account.length) {
		case 0:
			System.out.println("Nhóm không có thành viên");
			break;
		case 1:
			System.out.println("Nhóm này có một thành viên");
			break;
		case 2:
			System.out.println("Nhóm này có hải thành viên");
			break;
		case 3:
			System.out.println("Nhóm này có ba thành viên");
			break;
		}
	}
}
