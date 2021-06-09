package com.fuse.bankManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuse.bankManagementSystem.dtos.AccountDto;
import com.fuse.bankManagementSystem.services.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@GetMapping("/")
	public ResponseEntity<List<AccountDto>> getAllAccount() {
		return new ResponseEntity<List<AccountDto>>(accountService.getAllAccounts(), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<AccountDto> saveAccount(@RequestBody AccountDto account) {
		return new ResponseEntity<AccountDto>(accountService.saveAccount(account), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable String id) {
		return new ResponseEntity<AccountDto>(accountService.getAccountById(id), HttpStatus.FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AccountDto> updateAccount(@PathVariable String id, @RequestBody AccountDto account) {
		return new ResponseEntity<AccountDto>(accountService.updateAccount(id, account), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteAccount(@PathVariable String id) {
		accountService.deleteAccount(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<List<AccountDto>> getAccountByUserId(@PathVariable String userId) {
		return new ResponseEntity<List<AccountDto>>(accountService.getAccountByUserId(userId), HttpStatus.OK);
	}

}
