package com.vti.entity;

public class HinhTron  extends HinhHoc{
	public static float pi = (float) 3.14;
	public HinhTron(float a,float b) throws Exception {
		super(a,b);
	}

	@Override
	public float Dientich(float a, float b) {
		return (float) (pi*(Math.pow(a, 2)));
	}

	@Override
	public float Chuvi(float a, float b) {
		return pi*a*2;
	}
}
