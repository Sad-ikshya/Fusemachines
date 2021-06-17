package com.fuse.bankManagementSystem.services;

import org.springframework.data.domain.Page;

import com.fuse.bankManagementSystem.dtos.TransactionDto;
import com.fuse.bankManagementSystem.dtos.TransactionResponseDto;

public interface TransactionService {
	public Page<TransactionResponseDto> getAllTransaction(int page, int size, String sortBy);

	public TransactionResponseDto getTransactionById(String id);

	public TransactionDto saveTransaction(TransactionDto transaction);

	public TransactionDto updateTransaction(String id, TransactionDto transaction);

	public void deleteTransaction(String id);

	Page<TransactionDto> getTransactionByAmmount(double ammountGT, double ammountLt, int page, int size, String sortBy);

}
