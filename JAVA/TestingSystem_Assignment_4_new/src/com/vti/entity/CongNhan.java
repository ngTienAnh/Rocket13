package com.vti.entity;

public class CongNhan extends CanBo {
	private int CapBac;

	public CongNhan(String hoTen, int tuoi, GioiTinh gioiTinh, String diaChi, int capBac) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		CapBac = capBac;
	}

	@Override
	public String toString() {
		return super.toString() + "CongNhan [CapBac=" + CapBac + "]";
	}

	public CongNhan() {
	}

	public int getCapBac() {
		return CapBac;
	}

	public void setCapBac(int capBac) {
		CapBac = capBac;
	}
	
	
	
	
}
