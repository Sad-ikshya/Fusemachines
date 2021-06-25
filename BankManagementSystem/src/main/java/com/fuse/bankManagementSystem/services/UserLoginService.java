package com.fuse.bankManagementSystem.services;

import com.fuse.bankManagementSystem.dtos.UserLoginDto;

public interface UserLoginService {

	public UserLoginDto saveUserLogin(UserLoginDto userLogin);

	public UserLoginDto getByUsername(String username);

}