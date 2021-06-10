package com.fuse.bankManagementSystem.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fuse.bankManagementSystem.dtos.AccountDto;
import com.fuse.bankManagementSystem.entities.AccounType;

public interface AccountService {
	public Page<AccountDto> getAllAccounts(int page, int size, String sortBy);

	public AccountDto saveAccount(AccountDto account);

	public AccountDto getAccountById(String id);

	public AccountDto updateAccount(String id, AccountDto account);

	public void deleteAccount(String id);

	public List<AccountDto> getAccountByUserId(String userId);

	public Page<AccountDto> getByAccountType(AccounType accountType, int page, int size, String sortBy);

}
