package com.vti.entity;

import java.util.ArrayList;

public abstract class phone  {
	protected ArrayList<contact> contacts;
	
	public abstract void creatContact();
	public abstract void insertContact(String name, String phone);
	public abstract void removeContact(String name);
	public abstract void updateContact(String name, String newPhone);
	public abstract void searchContact(String name);
}
