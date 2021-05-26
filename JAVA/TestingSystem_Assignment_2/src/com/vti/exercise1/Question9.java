package com.vti.exercise1;

import com.vti.entity.Department;

public class Question9 {
	public void listDepartment(Department Dep[]) {
		for (Department dep : Dep) {
			System.out.println("ID: " + dep.ID);
			System.out.println("Name: " + dep.Name);
		}
	}
}
