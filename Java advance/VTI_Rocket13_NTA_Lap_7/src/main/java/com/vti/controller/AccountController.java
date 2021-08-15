package com.vti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.AccountDto;
import com.vti.entity.Account;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForUpdating;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin("*")
public class AccountController {

	@Autowired
	private IAccountService service;

	@GetMapping()
	public ResponseEntity<?> getAllAccount(Pageable pageable, @RequestParam(required = false) String search) {
		Page<Account> entities = service.getAllAccount(pageable, search);

		// convert entities --> dtos
		// https://stackoverflow.com/questions/39036771/how-to-map-pageobjectentity-to-pageobjectdto-in-spring-data-rest
		Page<AccountDto> dtoPage = entities.map(new Function<Account, AccountDto>() {
			@Override
			public AccountDto apply(Account account) {
				AccountDto dto = new AccountDto(account.getId(), account.getEmail(), account.getUsername(),
						account.getFullName(), account.getDepartment().getName(),
						account.getPosition().getName().toString(), account.getCreateDate());
				return dto;
			}
		});

		return new ResponseEntity<>(dtoPage, HttpStatus.OK);
	}


	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getAccountByID(@PathVariable(name = "id") short id) {
		Account account = service.getAccountById(id);
		AccountDto dto = new AccountDto(account.getId(), account.getEmail(), account.getUsername(),
				account.getFullName(), account.getDepartment().getName(), account.getPosition().getName().toString(),
				account.getCreateDate());
		return new ResponseEntity<AccountDto>(dto, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createDepartment(AccountFormForCreating form) {
		service.createAccount(form);
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}
	
	//demo cần request
//	@PostMapping()
//	public ResponseEntity<?> createDepartment(@RequestBody AccountFormForCreating form) {
//		service.createAccount(form);
//		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
//	}

//	demo can request	
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") short id,
//			@RequestBody AccountFormForUpdating form) {
//		service.updateAccount(id, form);
//		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
//	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") short id,
			AccountFormForUpdating form) {
		service.updateAccount(id, form);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") short id) {
		service.deleteAccount(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
}
