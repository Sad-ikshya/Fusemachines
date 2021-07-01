package com.fuse.mockitoPractice;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fuse.mockitoPractice.dtos.UserDetailsDto;

public class UserDetailsDtoTest {
	UserDetailsDto userDetails = new UserDetailsDto(new BigInteger("11220"), "Ram", "Sharma", "Kathmandu",
			new BigInteger("98611876900"), "Student");

	@Test
	public void dtoClassTest() {
		Assertions.assertEquals(new BigInteger("11220"), userDetails.getId());
		Assertions.assertEquals("Ram", userDetails.getFirstName());
		Assertions.assertEquals("Sharma", userDetails.getLastname());
		Assertions.assertEquals("Kathmandu", userDetails.getAddress());
		Assertions.assertEquals(new BigInteger("98611876900"), userDetails.getPhoneNumber());
		Assertions.assertEquals("Student", userDetails.getOccupation());
	}
}
