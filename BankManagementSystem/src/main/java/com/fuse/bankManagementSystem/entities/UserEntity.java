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
@Document("users")
@Builder
public class UserEntity {
	@Id
	private String id;
	private String firstName;
	private String middleName;
	private String lastName;
	private Gender gender;
	private String address;
	private BigInteger phoneNumber;
	private String email;
	private List<String> accounts;
}
