package com.fuse.bankManagementSystem.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fuse.bankManagementSystem.dtos.AccountDto;
import com.fuse.bankManagementSystem.dtos.AccountResponseDto;
import com.fuse.bankManagementSystem.entities.AccountTypes;
import com.fuse.bankManagementSystem.services.AccountService;
import com.fuse.bankManagementSystem.services.UserService;
import com.fuse.bankManagementSystem.utility.Response;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountService accountService;
	private UserService userService;

	@GetMapping("/")
	public ResponseEntity<Map<String, Object>> getAllAccount(@RequestParam(defaultValue = "") String accountType,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size,
			@RequestParam(defaultValue = "id") String sortBy) {
		Response<AccountResponseDto> response = new Response<AccountResponseDto>();
		if (!accountType.isEmpty()) {
			Page<AccountResponseDto> pagedData = accountService.getByAccountType(AccountTypes.valueOf(accountType),
					page, size, sortBy);
			return response.getPageResponseEntity(pagedData, HttpStatus.OK);

		}
		return response.getPageResponseEntity(accountService.getAllAccounts(page, size, sortBy), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<AccountDto> saveAccount(@RequestBody AccountDto account) {
		// UserDto user = userService.getUserById(account.getUser().getId());
		// if (user.id.isEmpty()) {
		// throw new UserNotFoundException();
		// } else {
		return new ResponseEntity<AccountDto>(accountService.saveAccount(account), HttpStatus.CREATED);

	}

	@GetMapping("/{id}")
	public ResponseEntity<AccountResponseDto> getAccountById(@PathVariable String id) {
		return new ResponseEntity<AccountResponseDto>(accountService.getAccountById(id), HttpStatus.FOUND);
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
}
