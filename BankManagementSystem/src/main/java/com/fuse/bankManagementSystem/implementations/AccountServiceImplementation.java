package com.fuse.bankManagementSystem.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fuse.bankManagementSystem.dtos.AccountDto;
import com.fuse.bankManagementSystem.dtos.AccountResponseDto;
import com.fuse.bankManagementSystem.dtos.TransactionResponseDto;
import com.fuse.bankManagementSystem.entities.AccountEntity;
import com.fuse.bankManagementSystem.entities.AccountTypes;
import com.fuse.bankManagementSystem.repositories.AccountRepository;
import com.fuse.bankManagementSystem.services.AccountService;
import com.fuse.bankManagementSystem.services.TransactionService;

@Service
public class AccountServiceImplementation implements AccountService {
	@Autowired
	AccountRepository accountRepository;

	@Autowired
	TransactionService transactionService;

	@Override
	public Page<AccountResponseDto> getAllAccounts(int page, int size, String sortBY) {
		Pageable pageRequest = PageRequest.of(page, size, Sort.by(sortBY));
		Page<AccountEntity> account = accountRepository.findAll(pageRequest);
		List<AccountResponseDto> accountDtoList = new ArrayList<>();
		for (AccountEntity a : account) {
			List<TransactionResponseDto> transactions = new ArrayList<>();
			for (String id : a.getTransactions()) {
				TransactionResponseDto transaction = transactionService.getTransactionById(id);
				transactions.add(transaction);
			}
			AccountResponseDto accountDto = AccountResponseDto.builder().id(a.getId()).accounType(a.getAccounType())
					.accountNumber(a.getAccountNumber()).balance(a.getBalance()).transactions(transactions).build();

			accountDtoList.add(accountDto);
		}
		Page<AccountResponseDto> pagedData = new PageImpl<>(accountDtoList);
		return pagedData;

	}

	@Override
	public AccountDto saveAccount(AccountDto account) {

		AccountEntity accountEntity = AccountEntity.builder().id(account.getId()).accounType(account.getAccounType())
				.accountNumber(account.getAccountNumber()).balance(account.getBalance()).build();
		accountEntity = accountRepository.save(accountEntity);
		account.setId(accountEntity.getId());
		return account;
	}

	@Override
	public AccountResponseDto getAccountById(String id) {
		AccountEntity account = accountRepository.findById(id).get();
		List<TransactionResponseDto> transactions = new ArrayList<>();
		for (String transactionId : account.getTransactions()) {
			TransactionResponseDto transaction = transactionService.getTransactionById(transactionId);
			transactions.add(transaction);
		}
		return AccountResponseDto.builder().id(account.getId()).accounType(account.getAccounType())
				.accountNumber(account.getAccountNumber()).transactions(transactions).balance(account.getBalance())
				.build();
	}

	@Override
	public AccountDto updateAccount(String id, AccountDto account) {
		AccountEntity accountEntity = AccountEntity.builder().id(id).accounType(account.getAccounType())
				.accountNumber(account.getAccountNumber()).balance(account.getBalance()).build();
		accountEntity = accountRepository.save(accountEntity);
		account.setId(accountEntity.getId());
		return account;
	}

	@Override
	public void deleteAccount(String id) {
		accountRepository.deleteById(id);
	}

	@Override
	public Page<AccountResponseDto> getByAccountType(AccountTypes accountType, int page, int size, String sortBy) {
		Pageable pageRequest = PageRequest.of(page, size, Sort.by(sortBy));
		Page<AccountEntity> account = accountRepository.findByAccountType(accountType, pageRequest);
		List<AccountResponseDto> accountDtoList = new ArrayList<>();
		for (AccountEntity a : account) {
			List<TransactionResponseDto> transactions = new ArrayList<>();
			for (String id : a.getTransactions()) {
				TransactionResponseDto transaction = transactionService.getTransactionById(id);
				transactions.add(transaction);
			}
			AccountResponseDto accountDto = AccountResponseDto.builder().id(a.getId()).accounType(a.getAccounType())
					.accountNumber(a.getAccountNumber()).transactions(transactions).balance(a.getBalance()).build();

			accountDtoList.add(accountDto);
		}
		Page<AccountResponseDto> pagedData = new PageImpl<>(accountDtoList);
		return pagedData;
	}
}
