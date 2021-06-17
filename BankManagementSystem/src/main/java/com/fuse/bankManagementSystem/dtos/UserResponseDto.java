package com.fuse.bankManagementSystem.dtos;

import java.math.BigInteger;
import java.util.List;

import com.fuse.bankManagementSystem.entities.Gender;

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
public class UserResponseDto {
	private String id;
	private String firstName;
	private String middleName;
	private String lastName;
	private Gender gender;
	private String address;
	private BigInteger phoneNumber;
	private String email;
	private List<AccountResponseDto> accounts;

}
