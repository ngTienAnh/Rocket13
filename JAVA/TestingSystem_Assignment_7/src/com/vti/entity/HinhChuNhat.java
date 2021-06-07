package com.vti.entity;

public class HinhChuNhat extends HinhHoc {
	public HinhChuNhat (float a, float b) throws Exception {
		super(a,b);
	}

	@Override
	public float Dientich(float a, float b) {
		// TODO Auto-generated method stub
		return (float) (a*b);
	}

	@Override
	public float Chuvi(float a, float b) {
		// TODO Auto-generated method stub
		return a+b+a+b;
	}
}
