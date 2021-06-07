package com.vti.entity;

public abstract class HinhHoc {
	private float a;
	private float b;
	public static int COUNT = 0;
	
	
	
	public HinhHoc(float a, float b) throws Exception {
		super();
		if(COUNT <= Config.Maximun_number_shape) {
			this.a = a;
			this.b = b;
			COUNT++;
		}else {
			throw new HinhHocException();
		}
	}
	
	public abstract float Dientich(float a, float b);
	public abstract float Chuvi(float a, float b);
	
	
}
