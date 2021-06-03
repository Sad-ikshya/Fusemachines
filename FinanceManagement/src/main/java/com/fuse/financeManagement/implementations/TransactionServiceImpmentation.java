package com.fuse.financeManagement.implementations;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fuse.financeManagement.models.Transaction;
import com.fuse.financeManagement.services.TransactionService;

@Service
public class TransactionServiceImpmentation implements TransactionService {

	private List<Transaction> transactions;

	public TransactionServiceImpmentation() {
		transactions = new ArrayList<Transaction>();
	}

	@Override
	public List<Transaction> getTransactions() {
		return transactions;
	}

	@Override
	public Transaction createTransaction(Transaction transaction) {
		transactions.add(transaction);
		return transaction;
	}

	@Override
	public Transaction getTransactionById(BigInteger id) {
		for (Transaction t : transactions) {
			if (t.getId().equals(id)) {
				return t;
			}
		}
		return null;
	}

	@Override
	public Transaction updateTransaction(BigInteger id, Transaction updatedTransaction) {
		Transaction tran = this.getTransactionById(id);
		transactions.set(transactions.indexOf(tran), updatedTransaction);
		return updatedTransaction;
	}

	@Override
	public void deleteTrnasaction(BigInteger id) {
		Transaction transac = this.getTransactionById(id);
		transactions.remove(transac);

	}

}
