package com.vti.backend;

import com.vti.entity.Student;

public class Exercise_4 {
	public void Ques1() {

		Student st1 = new Student(1,"name1");
		Student st2 = new Student(5,"name2");
		Student st3 = new Student(7,"name3");
		Student st4 = new Student(10,"name4");
		Student st5 = new Student(0,"name5");
		Student stt[] = {st1,st2,st3,st4,st5};
		for(Student st : stt)
			st.toString();
	}
}
