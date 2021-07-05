package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="Department", catalog = "testingsystem2")
public class Department implements Serializable{
	@Column(name = "DepartmentID")
	@Id
	private short DepartmentID;
	
	@Column(name = "DepartmentName", nullable = false, length = 30, unique = true)
	private String DepartmentName;

	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })
	private List<Account> account;

	public Department(short departmentID, String departmentName, List<Account> account) {
		super();
		DepartmentID = departmentID;
		DepartmentName = departmentName;
		this.account = account;
	}

	public Department() {
		super();
	}

	public short getDepartmentID() {
		return DepartmentID;
	}

	public void setDepartmentID(short departmentID) {
		DepartmentID = departmentID;
	}

	public String getDepartmentName() {
		return DepartmentName;
	}

	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Department [DepartmentID=" + DepartmentID + ", DepartmentName=" + DepartmentName + ", account="
				+ account + "]";
	}

	
}
