package com.fuse.bankManagementSystem.services;

import java.util.List;

import com.fuse.bankManagementSystem.dtos.UserDto;

public interface UserService {
	public List<UserDto> getAllUser();

	public UserDto getUserById(String id);

	public UserDto saveUser(UserDto user);

	public UserDto updateUser(String id, UserDto user);

	public void deleteUser(String id);

}
