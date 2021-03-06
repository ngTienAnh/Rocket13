package com.vti.fontend;

import java.util.List;
import com.vti.entity.Account;
import com.vti.entity.DetailDepartment;
import com.vti.repository.AccountRepository;
import com.vti.repository.DetailDepartmentRepository;

public class demo {
	public static void main(String[] args) {
		System.out.println("Danh sách Account trên hệ thống");
		AccountRepository accRepository = new AccountRepository();
		List<Account> listAcc = accRepository.getAllAccount();
		for (Account account : listAcc) {
			System.out.println(account() + account.getUsername() + account.getDepartment().getName());
		}
		System.out.println("Danh sách DetailDepartment trên hệ thống");
		DetailDepartmentRepository detailDepartmentRepository = new DetailDepartmentRepository();
		List<DetailDepartment> listDetailDepartment = detailDepartmentRepository.getDetailDepartment();
		for (DetailDepartment detailDepartment : listDetailDepartment) {
			System.out.println("ID: " + detailDepartment.getId() + "" + "=Name: " + detailDepartment.getName()
					+ " Address: " + detailDepartment.getAddress().getName());
		}
	}
}