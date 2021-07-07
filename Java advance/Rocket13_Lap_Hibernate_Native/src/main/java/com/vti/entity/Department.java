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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Department", catalog = "testingsystem2")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Department implements Serializable{
	@Column(name = "DepartmentID")
	@Id
	private short DepartmentID;
	
	@Column(name = "DepartmentName", nullable = false, length = 30, unique = true)
	private String DepartmentName;

	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })
	private List<Account> accounts;

	public Department(short departmentID, String departmentName, List<Account> account) {
		super();
		DepartmentID = departmentID;
		DepartmentName = departmentName;
		this.accounts = account;
	}

	public Department(String departmentName) {
		DepartmentName = departmentName;
	}

	public Department() {
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
		return accounts;
	}

	public void setAccount(List<Account> account) {
		this.accounts = account;
	}

	@Override
	public String toString() {
		return "Department [DepartmentID=" + DepartmentID + ", DepartmentName=" + DepartmentName + ", account="
				+ accounts + "]";
	}

	
}
