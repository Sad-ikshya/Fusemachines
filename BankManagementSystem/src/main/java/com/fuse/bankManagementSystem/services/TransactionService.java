package com.fuse.bankManagementSystem.services;

import java.util.List;

import com.fuse.bankManagementSystem.dtos.TransactionDto;

public interface TransactionService {
	public List<TransactionDto> getAllTransaction();

	public TransactionDto getTransactionById(String id);

	public TransactionDto saveTransaction(TransactionDto transaction);

	public TransactionDto updateTransaction(String id, TransactionDto transaction);

	public void deleteTransaction(String id);

	public List<TransactionDto> getTransactionByAccountId(String accountId);

}
