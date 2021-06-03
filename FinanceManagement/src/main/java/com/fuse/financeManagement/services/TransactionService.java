package com.fuse.financeManagement.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fuse.financeManagement.models.Transaction;

@Service
public interface TransactionService {
	public List<Transaction> getTransactions();

	public Transaction createTransaction(Transaction transaction);

	public Transaction getTransactionById(BigInteger id);

	public Transaction updateTransaction(BigInteger id, Transaction transaction);

	public void deleteTrnasaction(BigInteger id);

}
