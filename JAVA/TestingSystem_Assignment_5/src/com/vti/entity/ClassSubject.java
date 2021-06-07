package com.vti.entity;

import java.util.ArrayList;

public class ClassSubject {
	private String ID;
	private String Subject;

	public String getSubject() {
		if(this.ID == "A")
			this.Subject = "Toán, lý, hóa";
		if(this.ID == "B")
			this.Subject = "Toán, hóa, sinh";
		if(this.ID == "C")
			this.Subject = "Văn, sử, địa";
		return this.Subject;
	}
	
	
	public ClassSubject(String iD) {
		super();
		ID = iD;
		Subject = getSubject();
	}


	@Override
	public String toString() {
		return "ClassSubject [ID=" + ID + ", Subject=" + this.getSubject() + "]";
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
}
