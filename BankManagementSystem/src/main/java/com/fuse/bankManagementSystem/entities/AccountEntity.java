package com.fuse.bankManagementSystem.entities;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
@Document
@Builder
public class AccountEntity {
	@Id
	public String id;
	@DBRef
	public UserEntity user;
	public AccounType accounType;
	public BigInteger accountNumber;
	public double balance;

}
