package com.fuse.bankManagementSystem.dtos;

import java.math.BigInteger;

import com.fuse.bankManagementSystem.entities.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class EmployeeDto {
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
