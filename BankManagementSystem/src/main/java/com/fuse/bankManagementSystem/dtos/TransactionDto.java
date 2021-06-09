package com.fuse.bankManagementSystem.dtos;

import java.math.BigInteger;
import java.util.Date;

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
	public BigInteger fromAccount;
	public AccountDto toAccount;

}
