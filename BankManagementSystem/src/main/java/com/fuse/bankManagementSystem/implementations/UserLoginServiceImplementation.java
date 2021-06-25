package com.fuse.bankManagementSystem.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuse.bankManagementSystem.dtos.UserDto;
import com.fuse.bankManagementSystem.dtos.UserLoginDto;
import com.fuse.bankManagementSystem.entities.UserEntity;
import com.fuse.bankManagementSystem.entities.UserLoginEntity;
import com.fuse.bankManagementSystem.repositories.UserLoginRepository;
import com.fuse.bankManagementSystem.services.UserLoginService;

@Service
public class UserLoginServiceImplementation implements UserLoginService {
	@Autowired
	UserLoginRepository userLoginRepository;

	@Override
	public UserLoginDto saveUserLogin(UserLoginDto userLogin) {
		UserEntity userEntity = UserEntity.builder().id(userLogin.getUser().getId()).build();
		UserLoginEntity userLoginEntity = UserLoginEntity.builder().id(userLogin.getId())
				.userName(userLogin.getUserName()).password(userLogin.getPassword()).user(userEntity).build();

		userLoginEntity = userLoginRepository.save(userLoginEntity);
		userLogin.setId(userLoginEntity.getId());
		return userLogin;

	}

	@Override
	public UserLoginDto getByUsername(String username) {
		UserLoginEntity userLogin = userLoginRepository.findByUserName(username);
		UserDto userDto = UserDto.builder().id(userLogin.getUser().getId()).build();
		UserLoginDto userLoginDto = UserLoginDto.builder().id(userLogin.getId()).userName(userLogin.getUserName())
				.password(userLogin.getPassword()).user(userDto).build();

		return userLoginDto;
	}
}
