package com.vti.entity;

import com.vti.entity.Position.PosititionName;

public class Position {
	private int ID;
	private PosititionName Name;
	
	public enum PosititionName {
			DEV, PM, SCRUM_MASTER, TEST;
	}

	public Position() {
		super();
	}

	public Position(int iD, PosititionName name) {
		super();
		ID = iD;
		Name = name;
	}
	
}
