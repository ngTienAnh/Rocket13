package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vti.Specification.AccountSpecification;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForUpdating;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.repository.IPositionReponsitory;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository accountRepository;
	@Autowired
	private IDepartmentRepository departmentRepository;
	@Autowired
	private IPositionReponsitory positionRepository;
	@SuppressWarnings("unused")
	private Specification<Account> where;

	@SuppressWarnings("deprecation")
	@Override
	public Page<Account> getAllAccount(Pageable pageable, String search) {
		Specification<Account> where = null;
		if (!StringUtils.isEmpty(search)) {
			AccountSpecification nameSpecification = new AccountSpecification("fullName", "LIKE", search);
			AccountSpecification emailSpecification = new AccountSpecification("email", "LIKE", search);
			AccountSpecification departmentSpecification = new AccountSpecification("department.name", "LIKE", search);
			where = Specification.where(nameSpecification).or(emailSpecification).or(departmentSpecification);
		}
		return accountRepository.findAll(where, pageable);
	}

	@Override
	public Account getAccountById(short id) {
		return accountRepository.getById(id);
	}

	@Override
	public void createAccount(AccountFormForCreating form) {
		Account account = new Account();
		Department department = departmentRepository.getById(form.getDepartmentId());
		Position position = positionRepository.getById(form.getPositionId());
		account.setEmail(form.getEmail());
		account.setUsername(form.getUsername());
		account.setFullName(form.getFullname());
		account.setDepartment(department);
		account.setPosition(position);
		accountRepository.save(account);
	}

	@Override
	public void updateAccount(short id, AccountFormForUpdating form) {
		Account account = accountRepository.getById(id);
		Department department = departmentRepository.getById(form.getDepartmentId());
		Position position = positionRepository.getById(form.getPositionId());
		account.setFullName(form.getFullname());
		account.setDepartment(department);
		account.setPosition(position);
		accountRepository.save(account);
	}

	@Override
	public void deleteAccount(short id) {
		accountRepository.deleteById(id);
	}
}
