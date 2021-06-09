package com.fuse.bankManagementSystem.services;

import java.util.List;

import com.fuse.bankManagementSystem.dtos.AccountDto;

public interface AccountService {
	public List<AccountDto> getAllAccounts();

	public AccountDto saveAccount(AccountDto account);

	public AccountDto getAccountById(String id);

	public AccountDto updateAccount(String id, AccountDto account);

	public void deleteAccount(String id);

	public List<AccountDto> getAccountByUserId(String userId);

}
