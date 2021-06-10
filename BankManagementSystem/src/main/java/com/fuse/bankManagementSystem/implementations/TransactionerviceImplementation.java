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
import com.fuse.bankManagementSystem.dtos.TransactionDto;
import com.fuse.bankManagementSystem.entities.AccountEntity;
import com.fuse.bankManagementSystem.entities.TransactionEntity;
import com.fuse.bankManagementSystem.repositories.AccountRepository;
import com.fuse.bankManagementSystem.repositories.TransactionRepository;
import com.fuse.bankManagementSystem.services.AccountService;
import com.fuse.bankManagementSystem.services.TransactionService;

@Service
public class TransactionerviceImplementation implements TransactionService {
	@Autowired
	TransactionRepository transactionRepository;
	AccountRepository accountRepository;
	AccountService accountService;

	@Override
	public Page<TransactionDto> getAllTransaction(int page, int size, String sortBy) {
		Pageable pageRequest = PageRequest.of(page, size, Sort.by(sortBy));
		Page<TransactionEntity> transaction = transactionRepository.findAll(pageRequest);
		List<TransactionDto> transactionDtoList = new ArrayList<>();
		for (TransactionEntity t : transaction) {
			AccountDto account = AccountDto.builder().id(t.toAccount.getId()).build();
			TransactionDto transactionDto = TransactionDto.builder().id(t.getId()).date(t.getDate())
					.ammount(t.getAmmount()).toAccount(account).fromAccount(t.getFromAccount()).build();

			transactionDtoList.add(transactionDto);
		}
		Page<TransactionDto> pagefiedData = new PageImpl<>(transactionDtoList);
		return pagefiedData;
	}

	@Override
	public TransactionDto getTransactionById(String id) {
		TransactionEntity transaction = transactionRepository.findById(id).get();
		AccountDto account = AccountDto.builder().id(transaction.toAccount.getId()).build();
		return TransactionDto.builder().id(transaction.getId()).date(transaction.getDate())
				.ammount(transaction.getAmmount()).toAccount(account).fromAccount(transaction.getFromAccount()).build();
	}

	@Override
	public TransactionDto saveTransaction(TransactionDto transaction) {

		AccountEntity account = AccountEntity.builder().id(transaction.getToAccount().getId()).build();

		TransactionEntity transactionEntity = TransactionEntity.builder().id(transaction.getId())
				.date(transaction.getDate()).ammount(transaction.getAmmount()).toAccount(account)
				.fromAccount(transaction.getFromAccount()).build();

		transactionEntity = transactionRepository.save(transactionEntity);
		transaction.setId(transactionEntity.getId());

		return transaction;

	}

	@Override
	public TransactionDto updateTransaction(String id, TransactionDto transaction) {
		AccountEntity account = AccountEntity.builder().id(transaction.toAccount.getId()).build();
		TransactionEntity transactionEntity = TransactionEntity.builder().id(id).date(transaction.getDate())
				.ammount(transaction.getAmmount()).toAccount(account).fromAccount(transaction.getFromAccount()).build();

		transactionEntity = transactionRepository.save(transactionEntity);
		transaction.setId(transactionEntity.getId());
		return transaction;
	}

	@Override
	public void deleteTransaction(String id) {
		transactionRepository.existsById(id);

	}

	@Override
	public List<TransactionDto> getTransactionByAccountId(String accountId) {
		List<TransactionEntity> transaction = transactionRepository.getByToAccountId(accountId);
		List<TransactionDto> transactionDtoList = new ArrayList<>();
		for (TransactionEntity t : transaction) {
			AccountDto account = AccountDto.builder().id(t.getToAccount().getId()).build();
			TransactionDto transactionDto = TransactionDto.builder().id(t.getId()).date(t.getDate())
					.ammount(t.getAmmount()).toAccount(account).fromAccount(t.getFromAccount()).build();

			transactionDtoList.add(transactionDto);
		}
		return transactionDtoList;
	}

	@Override
	public Page<TransactionDto> getTransactionByAmmount(double ammountGT, double ammountLt, int page, int size,
			String sortBy) {
		Pageable pageRequest = PageRequest.of(page, size, Sort.by(sortBy));
		Page<TransactionEntity> transaction = transactionRepository.findByAmmount(ammountGT, ammountLt, pageRequest);

		List<TransactionDto> transactionDtoList = new ArrayList<>();
		for (TransactionEntity t : transaction) {
			AccountDto account = AccountDto.builder().id(t.toAccount.getId()).build();
			TransactionDto transactionDto = TransactionDto.builder().id(t.getId()).date(t.getDate())
					.ammount(t.getAmmount()).toAccount(account).fromAccount(t.getFromAccount()).build();

			transactionDtoList.add(transactionDto);
		}
		Page<TransactionDto> pagefiedData = new PageImpl<>(transactionDtoList);
		return pagefiedData;
	}
}
