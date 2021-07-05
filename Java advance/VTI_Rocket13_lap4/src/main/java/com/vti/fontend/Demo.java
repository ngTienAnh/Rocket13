package com.vti.fontend;

import java.util.List;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;

public class Demo {
	public static void main(String[] args) {
		AccountRepository repository = new AccountRepository();

		List<Account> list = repository.getAllAccount();
		for (Account account : list) {
			System.out.println("ID: " + account.getFullName());
		}
	}
}
