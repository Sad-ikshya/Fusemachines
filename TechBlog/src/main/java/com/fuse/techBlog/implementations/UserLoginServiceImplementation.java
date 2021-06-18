package com.fuse.techBlog.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuse.techBlog.dtos.UserLoginDto;
import com.fuse.techBlog.entities.UserLoginEntity;
import com.fuse.techBlog.repositories.UserLoginRepository;
import com.fuse.techBlog.services.UserLoginService;

@Service
public class UserLoginServiceImplementation implements UserLoginService {
	@Autowired
	private UserLoginRepository userLoginRepository;

	@Override
	public UserLoginDto register(UserLoginDto userLogin) {
		UserLoginEntity userLoginEntity = UserLoginEntity.builder().userId(userLogin.getUserId())
				.username(userLogin.getUsername()).password(userLogin.getPassword()).build();

		userLoginRepository.save(userLoginEntity);
		return userLogin;
	}

}
