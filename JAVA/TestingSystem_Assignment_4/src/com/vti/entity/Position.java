package com.vti.entity;

import com.vti.entity.Position.PosititionName;

public class Position {
	public int ID;
	public PosititionName Name;
	
	public enum PosititionName {
			DEV, PM, SCRUM_MASTER, TEST;
	}
}
