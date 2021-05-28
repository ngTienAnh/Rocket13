package com.vti.entity;

import java.util.ArrayList;

public class VietnamesePhone extends phone {

	@Override
	public void insertContact(String name, String phone) {
		// TODO Auto-generated method stub
		contact ct = new contact(name, phone);
		contacts.add(ct);
	}

	@Override
	public void removeContact(String name) {
		// TODO Auto-generated method stub
		contacts.removeIf(contact -> contact.getName().equals(name));
	}

	@Override
	public void updateContact(String name, String newPhone) {
		// TODO Auto-generated method stub
		for (contact contact : contacts) {
			if (contact.getName().equals(name)) {
				contact.setPhone(newPhone);
			}
		}
	}

	@Override
	public void searchContact(String name) {
		// TODO Auto-generated method stub
		for (contact contact : contacts) {
			if (contact.getName().equals(name)) {
				System.out.println(contact);
			}
		}
	}

	@Override
	public void creatContact() {
		// TODO Auto-generated method stub
		contacts = new ArrayList<contact>();
	}

}
