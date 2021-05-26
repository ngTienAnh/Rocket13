package com.vti.exercise1;

import com.vti.entity.Department;

public class Question11 {
	public void listDepartment(Department Dep[]) {
		for (int i = 0; i < Dep.length; i++) {
			printDepartment(Dep[i], i);
		}
	}

	public void printDepartment(Department Dep, int i) {
		System.out.println("\nThông tin department thứ " + i + " là:");
		System.out.println("\tID: " + Dep.ID);
		System.out.println("\tName: " + Dep.Name);
	}
}
