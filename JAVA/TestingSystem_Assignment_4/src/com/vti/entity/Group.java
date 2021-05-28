package com.vti.entity;

import java.time.LocalDate;

public class Group {
	public int ID;
	private String Name;
	private int CreatorID;
	private LocalDate creatdate;
	private Account[] Account;

	public Group(int iD, String name, int creatorID, LocalDate creatdate, com.vti.entity.Account[] account) {
		super();
		ID = iD;
		Name = name;
		CreatorID = creatorID;
		this.creatdate = creatdate;
		Account = account;
	}

	public Group() {
		super();
	}

	public Group(String name, int creatorID, LocalDate creatdate, com.vti.entity.Account[] account) {
		super();
		Name = name;
		CreatorID = creatorID;
		this.creatdate = creatdate;
		Account = account;
	}

	public Group(String name, int creatorID, LocalDate creatdate, String acc[]) {
		super();
		Name = name;
		CreatorID = creatorID;
		this.creatdate = creatdate;
		Account ac[] = null;
		for (int i = 0; i < acc.length; i++) 
			ac[i].setUserName(acc[i]);
		this.Account = ac;
	}

}
