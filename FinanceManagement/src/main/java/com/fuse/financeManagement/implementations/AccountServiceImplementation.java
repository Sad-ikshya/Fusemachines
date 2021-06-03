package com.fuse.financeManagement.implementations;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fuse.financeManagement.models.Account;
import com.fuse.financeManagement.services.AccountService;

@Service
public class AccountServiceImplementation implements AccountService {
	private List<Account> accounts;

	public AccountServiceImplementation() {
		accounts = new ArrayList<Account>();
	}

	@Override
	public List<Account> getAccountHolders() {
		return accounts;

	}

	@Override
	public Account createAccount(Account account) {
		accounts.add(account);
		return account;
	}

	@Override
	public Account getAccountById(BigInteger id) {
		for (Account a : accounts) {
			if (a.getId().equals(id)) {
				return a;
			}
		}
		return null;
	}

	@Override
	public Account updateAccount(BigInteger id, Account updatedAccount) {
		Account acc = this.getAccountById(id);
		accounts.set(accounts.indexOf(acc), updatedAccount);
		return updatedAccount;
	}

	@Override
	public void deleteAccount(BigInteger id) {
		Account ac = this.getAccountById(id);
		accounts.remove(ac);

	}

}
