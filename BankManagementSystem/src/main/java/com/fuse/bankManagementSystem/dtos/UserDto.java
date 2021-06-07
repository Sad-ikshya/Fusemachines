package com.fuse.bankManagementSystem.dtos;

import java.math.BigInteger;

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
public class UserDto {
	public String id;
	public String firstName;
	public String middleName;
	public String lastName;
	public Gender gender;
	public String address;
	public BigInteger phoneNumber;
	public String email;

}
