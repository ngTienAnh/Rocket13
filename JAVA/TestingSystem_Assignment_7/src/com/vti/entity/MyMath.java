package com.vti.entity;

public class MyMath {
	public static int sum(int a, int b) {
		return (int) (a+b);
	}
	public static int min (int a, int b) {
		if(a>=b) return b;
		else return a;
	}
}
