package com.vti.form;

public class AccountFormForCreating {
	private String email;
	private String username;
	private String fullname;
	private short departmentId;
	private short positionId;
	public AccountFormForCreating(String email, String username, String fullname, short departmentId,
			short positionId) {
		super();
		this.email = email;
		this.username = username;
		this.fullname = fullname;
		this.departmentId = departmentId;
		this.positionId = positionId;
	}
	public AccountFormForCreating() {
		super();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public short getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(short departmentId) {
		this.departmentId = departmentId;
	}
	public short getPositionId() {
		return positionId;
	}
	public void setPositionId(short positionId) {
		this.positionId = positionId;
	}
	
	
}
