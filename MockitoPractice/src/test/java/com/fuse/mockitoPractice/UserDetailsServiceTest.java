package com.fuse.mockitoPractice;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import com.fuse.mockitoPractice.services.UserDetailsService;
import com.fuse.mockitoPractice.dtos.UserDetailsDto;

public class UserDetailsServiceTest {
	@Mock
	static UserDetailsService userDetailsService;

	@BeforeAll
	static void setup() {
		userDetailsService = mock(UserDetailsService.class);
	}

	@Test
	public void testAddUserFunction() {
		UserDetailsDto userDetail = new UserDetailsDto(new BigInteger("2233"), "Bilson", "Naga", "Suryabinayak",
				new BigInteger("9813456788"), "Job");

		when(userDetailsService.addUser(userDetail)).thenReturn(userDetail);
		UserDetailsDto addedUser = userDetailsService.addUser(userDetail);
		Assertions.assertEquals(new BigInteger("2233"), addedUser.getId());
		Assertions.assertEquals("Bilson", addedUser.getFirstName());
		Assertions.assertEquals("Naga", addedUser.getLastname());
		Assertions.assertEquals("Suryabinayak", addedUser.getAddress());
		Assertions.assertEquals(new BigInteger("9813456788"), addedUser.getPhoneNumber());
		Assertions.assertEquals("Job", addedUser.getOccupation());
	}

	@Test
	public void testGetAllUserFunction() {
		UserDetailsDto userDetail = new UserDetailsDto(new BigInteger("12345"), "Sadikshya", "Shrestha", "Thali",
				new BigInteger("9813951739"), "Student");
		List<UserDetailsDto> users = new ArrayList<>();
		users.add(userDetail);
		when(userDetailsService.getAllUsers()).thenReturn(users);

		Assertions.assertTrue(userDetailsService.getAllUsers().contains(userDetail));
		Assertions.assertTrue(userDetailsService.getAllUsers().size() == 1);

		verify(userDetailsService, times(2)).getAllUsers();

	}
}
