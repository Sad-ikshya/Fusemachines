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

import com.fuse.bankManagementSystem.dtos.AccountResponseDto;
import com.fuse.bankManagementSystem.dtos.TransactionDto;
import com.fuse.bankManagementSystem.dtos.TransactionResponseDto;
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
	public Page<TransactionResponseDto> getAllTransaction(int page, int size, String sortBy) {
		Pageable pageRequest = PageRequest.of(page, size, Sort.by(sortBy));
		Page<TransactionEntity> transaction = transactionRepository.findAll(pageRequest);
		List<TransactionResponseDto> transactionDtoList = new ArrayList<>();
		for (TransactionEntity t : transaction) {
			AccountResponseDto account = accountService.getAccountById(t.getReceiptAccount());
			TransactionResponseDto transactionDto = TransactionResponseDto.builder().id(t.getId()).date(t.getDate())
					.ammount(t.getAmmount()).transactionType(t.getTransactionType()).receiptAccount(account).build();

			transactionDtoList.add(transactionDto);
		}
		Page<TransactionResponseDto> pagefiedData = new PageImpl<>(transactionDtoList);
		return pagefiedData;
	}

	@Override
	public TransactionResponseDto getTransactionById(String id) {
		TransactionEntity transaction = transactionRepository.findById(id).get();

		return TransactionResponseDto.builder().id(transaction.getId()).date(transaction.getDate())
				.ammount(transaction.getAmmount()).transactionType(transaction.getTransactionType()).build();
	}

	@Override
	public TransactionDto saveTransaction(TransactionDto transaction) {
		TransactionEntity transactionEntity = TransactionEntity.builder().id(transaction.getId())
				.date(transaction.getDate()).ammount(transaction.getAmmount())
				.receiptAccount(transaction.getReceiptAccount()).transactionType(transaction.getTransactionType())
				.build();

		transactionEntity = transactionRepository.save(transactionEntity);
		transaction.setId(transactionEntity.getId());

		return transaction;

	}

	@Override
	public TransactionDto updateTransaction(String id, TransactionDto transaction) {
		TransactionEntity transactionEntity = TransactionEntity.builder().id(id).date(transaction.getDate())
				.ammount(transaction.getAmmount()).receiptAccount(transaction.getReceiptAccount())
				.transactionType(transaction.getTransactionType()).build();

		transactionEntity = transactionRepository.save(transactionEntity);
		transaction.setId(transactionEntity.getId());

		return transaction;
	}

	@Override
	public void deleteTransaction(String id) {
		transactionRepository.existsById(id);

	}

	@Override
	public Page<TransactionDto> getTransactionByAmmount(double ammountGT, double ammountLt, int page, int size,
			String sortBy) {
		Pageable pageRequest = PageRequest.of(page, size, Sort.by(sortBy));
		Page<TransactionEntity> transaction = transactionRepository.findByAmmount(ammountGT, ammountLt, pageRequest);

		List<TransactionDto> transactionDtoList = new ArrayList<>();
		for (TransactionEntity t : transaction) {

			TransactionDto transactionDto = TransactionDto.builder().id(t.getId()).date(t.getDate())
					.ammount(t.getAmmount()).transactionType(t.getTransactionType())
					.receiptAccount(t.getReceiptAccount()).build();

			transactionDtoList.add(transactionDto);
		}
		Page<TransactionDto> pagefiedData = new PageImpl<>(transactionDtoList);
		return pagefiedData;
	}
}
