package com.fuse.financeManagement.implementations;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fuse.financeManagement.models.Account;
import com.fuse.financeManagement.models.AccountType;
import com.fuse.financeManagement.services.AccountService;
import com.fuse.financeManagement.utils.ListManipulator;

@Service
public class AccountServiceImplementation implements AccountService {
	private List<Account> accounts;

	public AccountServiceImplementation() {
		accounts = new ArrayList<Account>();
	}

	@Override
	public List<Account> getAccountHolders(int index, int pageLimit) {
		ListManipulator<Account> manipulator = new ListManipulator<Account>();

		return manipulator.getLimitedData(accounts, index, pageLimit);
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

	@Override
	public List<Account> getFilteredData(double minBalance) {
		return accounts.stream().filter(acc -> acc.getBalance() > minBalance).collect(Collectors.toList());

	}

	@Override
	public List<Account> getFilteredData(double minBalance, double maxBalance) {
		return accounts.stream().filter(acc -> maxBalance > acc.getBalance() && acc.getBalance() > minBalance)
				.collect(Collectors.toList());

	}

	@Override
	public List<Account> getFilteredData(AccountType accountType) {
		return accounts.stream().filter(acc -> acc.getType() == accountType).collect(Collectors.toList());

	}

}
