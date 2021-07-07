package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "DetailDepartment", catalog = "TestingSystem3")
@PrimaryKeyJoinColumn(name = "DepartmentID")
public class DetailDepartment extends Department implements Serializable {
	private Address address;
}
