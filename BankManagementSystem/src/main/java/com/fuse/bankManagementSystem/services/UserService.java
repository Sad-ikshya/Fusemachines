package com.fuse.bankManagementSystem.services;

import org.springframework.data.domain.Page;

import com.fuse.bankManagementSystem.dtos.UserDto;
import com.fuse.bankManagementSystem.entities.Gender;

public interface UserService {
	public Page<UserDto> getAllUser(Integer minpage, Integer maxpage, String sortBy);

	public UserDto getUserById(String id);

	public UserDto saveUser(UserDto user);

	public UserDto updateUser(String id, UserDto user);

	public void deleteUser(String id);

	public Page<UserDto> findByGender(Gender gender, Integer minpage, Integer maxpage, String sortBy);

}
