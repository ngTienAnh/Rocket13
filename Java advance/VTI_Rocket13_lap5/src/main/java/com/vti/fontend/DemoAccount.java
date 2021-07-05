package com.vti.fontend;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;

public class DemoAccount {
	public static void main(String[] args) {
		AccountRepository repository = new AccountRepository();
		Account ac = repository.Get_AccountByID((short) 1);
		System.out.println(ac.toString());
	}
}
