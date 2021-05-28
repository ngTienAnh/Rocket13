package com.vti.entity;

public class NhanVien extends CanBo{
	public NhanVien(String hoTen, int tuoi, GioiTinh gioiTinh, String diaChi, String congViec) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		CongViec = congViec;
	}

	private String CongViec;

	public NhanVien(String congViec) {
		super();
		CongViec = congViec;
	}

	@Override
	public String toString() {
		return super.toString() + "NhanVien [CongViec=" + CongViec + "]";
	}
}
