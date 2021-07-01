package com.fuse.mockitoPractice.dtos;

import java.math.BigInteger;
import java.util.UUID;

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
public class UserDetailsDto {
	private BigInteger id;
	private String firstName;
	private String lastname;
	private String address;
	private BigInteger phoneNumber;
	private String occupation;

}
