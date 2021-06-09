package com.fuse.bankManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuse.bankManagementSystem.dtos.TransactionDto;
import com.fuse.bankManagementSystem.services.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;

	@GetMapping("/")
	public ResponseEntity<List<TransactionDto>> getAllTransaction() {
		return new ResponseEntity<List<TransactionDto>>(transactionService.getAllTransaction(), HttpStatus.OK);

	}

	@PostMapping("/")
	public ResponseEntity<TransactionDto> saveTransaction(@RequestBody TransactionDto transaction) {
		return new ResponseEntity<TransactionDto>(transactionService.saveTransaction(transaction), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TransactionDto> getTransactionById(@PathVariable String id) {
		return new ResponseEntity<TransactionDto>(transactionService.getTransactionById(id), HttpStatus.FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TransactionDto> editTransaction(@PathVariable String id,
			@RequestBody TransactionDto transaction) {
		return new ResponseEntity<TransactionDto>(transactionService.updateTransaction(id, transaction), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteTransaction(@PathVariable String id) {
		transactionService.deleteTransaction(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@GetMapping("/getByAccountId/{accountId}")
	public ResponseEntity<List<TransactionDto>> getTransactionByAccountId(@PathVariable String accountId) {
		return new ResponseEntity<List<TransactionDto>>(transactionService.getTransactionByAccountId(accountId),
				HttpStatus.OK);
	}
}
