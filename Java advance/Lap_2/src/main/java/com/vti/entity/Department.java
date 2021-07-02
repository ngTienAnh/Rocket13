package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Department", catalog = "testingsystem")
public class Department implements Serializable {
	@Column(name = "DepartmentID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	@Column(name = "DepartmentName")
	private String name;
	
	/**
	* @return the id
	*/
	public short getId() {
	return id;
	}
	/**
	* @param id the id to set
	*/
	public void setId(byte id) {
	this.id = id;
	}
	/**
	* @return the name
	*/
	public String getName() {
	return name;
	}
	/**
	* @param name the name to set
	*/
	public void setName(String name) {
	this.name = name;
	}
	@Override
	public String toString() {
	return "Department [id=" + id + ", name=" + name + "]";}
}
