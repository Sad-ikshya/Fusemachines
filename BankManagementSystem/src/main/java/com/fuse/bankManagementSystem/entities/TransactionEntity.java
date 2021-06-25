package com.fuse.bankManagementSystem.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Document("transactions")
@Builder
public class TransactionEntity {
	@Id
	private String id;
	private Date date;
	private double ammount;
	private String receiptAccount;
	private TransactionTypes transactionType;
}
