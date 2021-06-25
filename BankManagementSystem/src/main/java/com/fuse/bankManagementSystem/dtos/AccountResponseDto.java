package com.fuse.bankManagementSystem.dtos;

import java.math.BigInteger;
import java.util.List;

import com.fuse.bankManagementSystem.entities.AccountTypes;

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
public class AccountResponseDto {
	public String id;
	public double balance;
	public AccountTypes accounType;
	public BigInteger accountNumber;
	public List<TransactionResponseDto> transactions;
}
