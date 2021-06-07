package com.vti.entity;

import java.util.ArrayList;

public class ClassSub {
	public ArrayList<ClassSubject> listClass;
	
	public ClassSub() {
		listClass = new ArrayList<ClassSubject>();
		ClassSubject cl1 = new ClassSubject("A");
		ClassSubject cl2 = new ClassSubject("B");
		ClassSubject cl3 = new ClassSubject("C");
		listClass.add(cl1);
		listClass.add(cl2);
		listClass.add(cl3);
	}

	@Override
	public String toString() {
		String x = null;
		int i = 0;
		for(ClassSubject cl : listClass) {
			x += i +"." + cl.toString() + "\n";
		}
		return x;
	}
	
}
