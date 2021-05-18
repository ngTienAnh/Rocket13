package com.vti.exercise;

import com.vti.entity.Department;

public class Question12 {
	public void listDepartment(Department Dep[]) {
		Question11 ques11 = new Question11();
		for(int i = 0; i < 2; i++) {
			ques11.printDepartment(Dep[i], i);
		}
	}
}
