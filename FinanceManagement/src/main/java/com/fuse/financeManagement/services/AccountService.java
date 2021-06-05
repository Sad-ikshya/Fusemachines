package com.fuse.financeManagement.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fuse.financeManagement.models.Account;
import com.fuse.financeManagement.models.AccountType;

@Service
public interface AccountService {
	public List<Account> getAccountHolders(int index, int dataLimit);

	public Account createAccount(Account account);

	public Account getAccountById(BigInteger id);

	public Account updateAccount(BigInteger id, Account account);

	public void deleteAccount(BigInteger id);

	public List<Account> getFilteredData(double minBalance);

	public List<Account> getFilteredData(double minBalance, double maxBalance);

	public List<Account> getFilteredData(AccountType accountType);
}
