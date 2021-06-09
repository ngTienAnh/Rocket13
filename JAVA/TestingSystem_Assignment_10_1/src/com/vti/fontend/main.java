package com.vti.fontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.Exercise1;
import com.vti.backend.Exercise_1;

public class main {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Exercise_1 ex1 = new Exercise_1();
		ex1.question1();
		ex1.question5();
		ex1.question2();
	}
}
