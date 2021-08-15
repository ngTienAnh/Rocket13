package com.vti.dto;

public class LoginInfoDto {
	private short id;

	private String fullName;

	public LoginInfoDto(short id, String fullName) {
		super();
		this.id = id;
		this.fullName = fullName;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


}
