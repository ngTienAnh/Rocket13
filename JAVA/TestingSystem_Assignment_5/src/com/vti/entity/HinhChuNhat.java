package com.vti.entity;

public class HinhChuNhat {
	private float Dai;
	private float Rong;
	
	public float TinhChuVi() {
		return 2*(Dai+Rong);
	}
	public float TinhDienTich() {
		return Dai*Rong;
	}
	public HinhChuNhat(float dai, float rong) {
		super();
		Dai = dai;
		Rong = rong;
	}
}
