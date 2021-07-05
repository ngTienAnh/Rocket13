package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Account" , catalog = "testingsystem2")
public class Account implements Serializable {
	@Column(name = "AccountID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short AccountID;
	
	@Column(name = "Email", length = 30, updatable = false, unique = true)
	private String Email;
	
	@Column(name = "Username", length = 30, updatable = false, unique = true)
	private String Username;
	
	@Column(name = "FullName", length = 30)
	private String FullName;
	
	@ManyToOne
	@JoinColumn(name = "DepartmentID", nullable = false)
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })
	private Department department;

	@ManyToOne
	@JoinColumn(name = "PositionID", nullable = false)
	private Position position;
	
	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;
	
	public Account(short accountID, String email, String username, String fullName, Department department,
			Position position, Date createDate) {
		super();
		AccountID = accountID;
		Email = email;
		Username = username;
		FullName = fullName;
		this.department = department;
		this.position = position;
		this.createDate = createDate;
	}
	public Account() {
	}
	public short getAccountID() {
		return AccountID;
	}
	public void setAccountID(short accountID) {
		AccountID = accountID;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Account [AccountID=" + AccountID + ", Email=" + Email + ", Username=" + Username + ", FullName="
				+ FullName + ", department=" + department + ", position=" + position + ", createDate=" + createDate
				+ "]";
	}


}
