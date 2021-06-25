package com.fuse.bankManagementSystem.entities;

import java.math.BigInteger;
import java.util.List;

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
@Document("accounts")
@Builder
public class AccountEntity {
	@Id
	private String id;
	private AccountTypes accounType;
	private BigInteger accountNumber;
	private double balance;
	private List<String> transactions;
}
