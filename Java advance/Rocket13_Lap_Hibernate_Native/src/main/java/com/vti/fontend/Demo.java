package com.vti.fontend;

import java.util.List;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;

public class Demo {
	public static void main(String[] args) {
		AccountRepository repository = new AccountRepository();

//		List<Account> list = repository.Get_From(); // select full
//		for (Account account : list) {
//			System.out.println("ID: " + account.getFullName());
//		}

		System.out.println("ID: " + repository.Get_From_id((short) 1).getFullName()); //select id

//		System.out.println("ID: " + repository.Get_From_Fullname((short) 3)); //select fullname

//		List<Account> list = repository.Get_From_Month(); //select from month current
//		for (Account account : list) {
//			System.out.println("ID: " + account.getFullName());
//		}
	}
}
