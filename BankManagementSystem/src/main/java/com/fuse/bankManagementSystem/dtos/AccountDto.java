package com.fuse.bankManagementSystem.dtos;

import java.math.BigInteger;

import com.fuse.bankManagementSystem.entities.AccounType;

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
public class AccountDto {
	public String id;
	public UserDto user;
	public AccounType accounType;
	public BigInteger accountNumber;
	public double balance;
}
