package com.fuse.financeManagement.controllers;

import java.math.BigInteger;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuse.financeManagement.models.Account;
import com.fuse.financeManagement.services.AccountService;

@RestController
@RequestMapping("/v1/account")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@GetMapping("/")
	public ResponseEntity<List<Account>> getAccountHolders() {

		return new ResponseEntity<List<Account>>(accountService.getAccountHolders(), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Account> save(@RequestBody Account account) {
		return new ResponseEntity<Account>(accountService.createAccount(account), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable BigInteger id) {
		return new ResponseEntity<Account>(accountService.getAccountById(id), HttpStatus.FOUND);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Account> update(@RequestBody Account account, @PathVariable BigInteger id) {
		return new ResponseEntity<Account>(accountService.updateAccount(id, account), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable BigInteger id) {
		accountService.deleteAccount(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<HttpStatus> Test() throws HttpMessageNotReadableException {
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
