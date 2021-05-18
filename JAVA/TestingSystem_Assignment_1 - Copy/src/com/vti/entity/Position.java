package com.vti.entity;

public class Position {
	public int ID;
	public PosititionName Name;
	
	public enum PosititionName {
			DEV, PM, SCRUM_MASTER, TEST;
	}
}
