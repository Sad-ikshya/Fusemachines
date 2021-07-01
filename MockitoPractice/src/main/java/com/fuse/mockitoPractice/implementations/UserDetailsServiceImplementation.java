package com.fuse.mockitoPractice.implementations;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fuse.mockitoPractice.dtos.UserDetailsDto;
import com.fuse.mockitoPractice.services.UserDetailsService;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

	private List<UserDetailsDto> users;

	public UserDetailsServiceImplementation() {
		users = new ArrayList<UserDetailsDto>();
	}

	@Override
	public UserDetailsDto addUser(UserDetailsDto userDetails) {
		users.add(userDetails);
		return userDetails;
	}

	@Override
	public UserDetailsDto getUserDetailsById(BigInteger id) {
		for (UserDetailsDto u : users) {
			if (u.getId().equals(id)) {
				return u;
			}
		}
		return null;
	}

	@Override
	public UserDetailsDto updateUser(BigInteger id, UserDetailsDto userDetails) {
		UserDetailsDto user = this.getUserDetailsById(id);
		users.set(users.indexOf(user), userDetails);
		return userDetails;
	}

	@Override
	public void deleteUser(BigInteger id) {
		UserDetailsDto user = this.getUserDetailsById(id);
		users.remove(user);
	}

	@Override
	public List<UserDetailsDto> getAllUsers() {
		return users;
	}

}
