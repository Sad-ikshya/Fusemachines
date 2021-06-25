package com.fuse.bankManagementSystem.services;

import org.springframework.data.domain.Page;

import com.fuse.bankManagementSystem.dtos.AccountDto;
import com.fuse.bankManagementSystem.dtos.AccountResponseDto;
import com.fuse.bankManagementSystem.entities.AccountTypes;

public interface AccountService {
	public Page<AccountResponseDto> getAllAccounts(int page, int size, String sortBy);

	public AccountDto saveAccount(AccountDto account);

	public AccountResponseDto getAccountById(String id);

	public AccountDto updateAccount(String id, AccountDto account);

	public void deleteAccount(String id);

	public Page<AccountResponseDto> getByAccountType(AccountTypes accountType, int page, int size, String sortBy);

}
