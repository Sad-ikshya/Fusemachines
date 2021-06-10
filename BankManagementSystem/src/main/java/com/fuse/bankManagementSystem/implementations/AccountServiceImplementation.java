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
import com.fuse.bankManagementSystem.dtos.UserDto;
import com.fuse.bankManagementSystem.entities.AccounType;
import com.fuse.bankManagementSystem.entities.AccountEntity;
import com.fuse.bankManagementSystem.entities.UserEntity;
import com.fuse.bankManagementSystem.repositories.AccountRepository;
import com.fuse.bankManagementSystem.services.AccountService;

@Service
public class AccountServiceImplementation implements AccountService {
	@Autowired
	AccountRepository accountRepository;

	@Override
	public Page<AccountDto> getAllAccounts(int page, int size, String sortBY) {
		Pageable pageRequest = PageRequest.of(page, size, Sort.by(sortBY));
		Page<AccountEntity> account = accountRepository.findAll(pageRequest);
		List<AccountDto> accountDtoList = new ArrayList<>();
		for (AccountEntity a : account) {
			UserDto user = UserDto.builder().id(a.user.getId()).build();
			AccountDto accountDto = AccountDto.builder().id(a.getId()).user(user).accounType(a.getAccounType())
					.accountNumber(a.getAccountNumber()).balance(a.getBalance()).build();

			accountDtoList.add(accountDto);
		}
		Page<AccountDto> pagedData = new PageImpl<>(accountDtoList);
		return pagedData;

	}

	@Override
	public AccountDto saveAccount(AccountDto account) {
		UserEntity user = UserEntity.builder().id(account.user.getId()).build();
		AccountEntity accountEntity = AccountEntity.builder().id(account.getId()).user(user)
				.accounType(account.getAccounType()).accountNumber(account.getAccountNumber())
				.balance(account.getBalance()).build();
		accountEntity = accountRepository.save(accountEntity);
		account.setId(accountEntity.getId());
		return account;
	}

	@Override
	public AccountDto getAccountById(String id) {
		AccountEntity account = accountRepository.findById(id).get();
		UserDto user = UserDto.builder().id(account.user.getId()).build();
		return AccountDto.builder().id(account.getId()).user(user).accounType(account.getAccounType())
				.accountNumber(account.getAccountNumber()).balance(account.getBalance()).build();
	}

	@Override
	public AccountDto updateAccount(String id, AccountDto account) {
		UserEntity user = UserEntity.builder().id(account.user.getId()).build();
		AccountEntity accountEntity = AccountEntity.builder().id(id).user(user).accounType(account.getAccounType())
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
	public List<AccountDto> getAccountByUserId(String userId) {
		List<AccountEntity> accountEntity = accountRepository.getByUserId(userId);
		List<AccountDto> accountDtoList = new ArrayList<>();
		for (AccountEntity account : accountEntity) {
			UserDto user = UserDto.builder().id(account.getUser().getId()).build();
			AccountDto accountDto = AccountDto.builder().id(account.getId()).user(user)
					.accounType(account.getAccounType()).accountNumber(account.getAccountNumber())
					.balance(account.getBalance()).build();

			accountDtoList.add(accountDto);
		}
		return accountDtoList;
	}

	@Override
	public Page<AccountDto> getByAccountType(AccounType accountType, int page, int size, String sortBy) {
		Pageable pageRequest = PageRequest.of(page, size, Sort.by(sortBy));
		Page<AccountEntity> account = accountRepository.findByAccountType(accountType, pageRequest);
		List<AccountDto> accountDtoList = new ArrayList<>();
		for (AccountEntity a : account) {
			UserDto user = UserDto.builder().id(a.user.getId()).build();
			AccountDto accountDto = AccountDto.builder().id(a.getId()).user(user).accounType(a.getAccounType())
					.accountNumber(a.getAccountNumber()).balance(a.getBalance()).build();

			accountDtoList.add(accountDto);
		}
		Page<AccountDto> pagedData = new PageImpl<>(accountDtoList);
		return pagedData;
	}

}
