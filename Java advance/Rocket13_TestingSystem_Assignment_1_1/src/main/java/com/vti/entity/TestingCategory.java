package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;


@Entity
@Table(name = "Department", catalog = "TestingSystem")
public class TestingCategory implements Serializable{
	@Column(name = "DepartmentID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	@Column(name = "DepartmentName", length = 30, nullable = false)
	private String name;
	public TestingCategory(short id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public TestingCategory() {
		super();
	}
	public short getId() {
		return id;
	}
	public void setId(short id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
