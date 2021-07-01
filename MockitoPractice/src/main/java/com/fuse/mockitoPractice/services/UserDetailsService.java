package com.fuse.mockitoPractice.services;

import java.math.BigInteger;
import java.util.List;

import com.fuse.mockitoPractice.dtos.UserDetailsDto;

public interface UserDetailsService {
	public List<UserDetailsDto> getAllUsers();

	public UserDetailsDto addUser(UserDetailsDto userDetails);

	public UserDetailsDto getUserDetailsById(BigInteger id);

	public UserDetailsDto updateUser(BigInteger id, UserDetailsDto userDetails);

	public void deleteUser(BigInteger id);

}
