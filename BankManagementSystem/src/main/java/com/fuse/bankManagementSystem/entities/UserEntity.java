package com.fuse.bankManagementSystem.entities;

import java.math.BigInteger;

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
@Document
@Builder
public class UserEntity {
	@Id
	public String id;
	public String firstName;
	public String middleName;
	public String lastName;
	public Gender gender;
	public String address;
	public BigInteger phoneNumber;
	public String email;
}
