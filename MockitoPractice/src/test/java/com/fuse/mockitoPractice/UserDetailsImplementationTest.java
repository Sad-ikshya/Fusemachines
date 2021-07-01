package com.fuse.mockitoPractice;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.fuse.mockitoPractice.dtos.UserDetailsDto;
import com.fuse.mockitoPractice.implementations.UserDetailsServiceImplementation;

public class UserDetailsImplementationTest {
	@Mock
	static UserDetailsServiceImplementation userDetails;

	@BeforeAll
	static void setup() {
		userDetails = new UserDetailsServiceImplementation();
	}

	@Test
	public void TestAddFunction() {
		UserDetailsDto user = new UserDetailsDto(new BigInteger("1110"), "hari", "lama", "mulpani",
				new BigInteger("9813954123"), "Business");

		userDetails.addUser(user);

		Assertions.assertTrue(userDetails.getAllUsers().size() == 1);
		Assertions.assertTrue(userDetails.getAllUsers().contains(user));

	}
}
