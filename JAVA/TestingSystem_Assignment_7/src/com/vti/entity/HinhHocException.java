package com.vti.entity;

public class HinhHocException extends Exception{
	public HinhHocException() {
		super("số lượng hình đã đạt tối đa " + Config.Maximun_number_shape);
	}
}
