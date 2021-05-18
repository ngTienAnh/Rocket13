package com.vti.exercise;

public class Question15 {
	public void listEvenNumber() {
		System.out.println("Danh sách số chẵn là: ");
		for (int i = 0; i < 21; i++) {
			if (i % 2 == 0)
				System.out.println("\t" + i);
		}
	}
}
