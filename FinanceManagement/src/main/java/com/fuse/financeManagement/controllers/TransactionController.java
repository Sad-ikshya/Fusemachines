package com.fuse.financeManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

import com.fuse.financeManagement.models.Transaction;
import com.fuse.financeManagement.services.TransactionService;

@RestController
@RequestMapping("/v1/transactions")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;

	@GetMapping("/")
	public ResponseEntity<List<Transaction>> getTransaction() {
		return new ResponseEntity<List<Transaction>>(transactionService.getTransactions(), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Transaction> save(@RequestBody Transaction transaction)
			throws HttpMessageNotReadableException {
		return new ResponseEntity<Transaction>(transactionService.createTransaction(transaction), HttpStatus.CREATED);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Transaction> getTransactionById(@PathVariable BigInteger id) {
		return new ResponseEntity<Transaction>(transactionService.getTransactionById(id), HttpStatus.FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Transaction> update(@PathVariable BigInteger id, @RequestBody Transaction transaction) {
		return new ResponseEntity<Transaction>(transactionService.updateTransaction(id, transaction), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable BigInteger id) {
		transactionService.deleteTrnasaction(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}
