package com.fuse.bankManagementSystem.dtos;

import java.util.Date;

import com.fuse.bankManagementSystem.entities.TransactionTypes;

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
@Builder
public class TransactionDto {
	public String id;
	public Date date;
	public double ammount;
	public String receiptAccount;
	public TransactionTypes transactionType;
}
