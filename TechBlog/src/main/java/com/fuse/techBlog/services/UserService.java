package com.fuse.techBlog.services;

import java.util.List;

import com.fuse.techBlog.dtos.UserDto;

public interface UserService {
	public List<UserDto> getAllUsers();

	public UserDto saveUser(UserDto user);

	public UserDto getUserById(String id);

	public UserDto updateUser(String id, UserDto user);

	public void deleteUser(String id);

}
