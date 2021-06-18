package com.fuse.techBlog.implementations;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fuse.techBlog.dtos.UserDto;
import com.fuse.techBlog.entities.UserEntity;
import com.fuse.techBlog.repositories.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException("User not found with name:" + email);
		}
		return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}

	public UserEntity save(UserDto user) {
		UserEntity newUser = UserEntity.builder().id(user.getId()).firstName(user.getFirstName())
				.middleName(user.getMiddleName()).lastName(user.getLastName())
				.password(bcryptEncoder.encode(user.getPassword())).email(user.getEmail())
				.phoneNumber(user.getPhoneNumber()).address(user.getAddress()).build();
		return userRepository.save(newUser);
	}
}