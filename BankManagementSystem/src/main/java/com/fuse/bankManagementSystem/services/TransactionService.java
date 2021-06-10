package com.fuse.bankManagementSystem.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fuse.bankManagementSystem.dtos.TransactionDto;

public interface TransactionService {
	public Page<TransactionDto> getAllTransaction(int page, int size, String sortBy);

	public TransactionDto getTransactionById(String id);

	public TransactionDto saveTransaction(TransactionDto transaction);

	public TransactionDto updateTransaction(String id, TransactionDto transaction);

	public void deleteTransaction(String id);

	public List<TransactionDto> getTransactionByAccountId(String accountId);

	Page<TransactionDto> getTransactionByAmmount(double ammountGT, double ammountLt, int page, int size, String sortBy);

}
