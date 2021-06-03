package com.fuse.financeManagement.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fuse.financeManagement.models.Account;

@Service
public interface AccountService {
	public List<Account> getAccountHolders();

	public Account createAccount(Account account);

	public Account getAccountById(BigInteger id);

	public Account updateAccount(BigInteger id, Account account);

	public void deleteAccount(BigInteger id);
}
