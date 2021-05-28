package com.vti.entity;

public class KySu extends CanBo {
	private String NganhDT;

	public KySu(String nganhDT) {
		super();
		NganhDT = nganhDT;
	}

	@Override
	public String toString() {
		return super.toString() + "KySu [NganhDT=" + NganhDT + "]";
	}

	public KySu(String hoTen, int tuoi, GioiTinh gioiTinh, String diaChi, String nganhDT) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		NganhDT = nganhDT;
	}
	
	
	
}
