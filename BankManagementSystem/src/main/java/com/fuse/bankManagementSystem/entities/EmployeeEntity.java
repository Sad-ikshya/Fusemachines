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
@Document("employees")
@Builder
public class EmployeeEntity {
	@Id
	private String id;
	private String firstName;
	private String middleName;
	private String lastName;
	private BigInteger phoneNumber;
	private String address;
	private Post post;
	private double salary;
	private String email;

}
