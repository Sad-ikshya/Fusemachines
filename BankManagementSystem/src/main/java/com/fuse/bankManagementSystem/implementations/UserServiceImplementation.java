package com.fuse.bankManagementSystem.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fuse.bankManagementSystem.dtos.UserDto;
import com.fuse.bankManagementSystem.entities.Gender;
import com.fuse.bankManagementSystem.entities.UserEntity;
import com.fuse.bankManagementSystem.repositories.UserRepository;
import com.fuse.bankManagementSystem.services.UserService;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public Page<UserDto> getAllUser(Integer minpage, Integer maxpage, String sortBy) {
		Pageable pageRequest = PageRequest.of(minpage, maxpage, Sort.by(sortBy));
		Page<UserEntity> user = userRepository.findAll(pageRequest);
		List<UserDto> userDtoList = new ArrayList<>();
		for (UserEntity u : user) {
			UserDto userDto = UserDto.builder().id(u.getId()).firstName(u.getFirstName()).middleName(u.getMiddleName())
					.lastName(u.getLastName()).gender(u.getGender()).address(u.getAddress())
					.phoneNumber(u.getPhoneNumber()).email(u.getEmail()).build();

			userDtoList.add(userDto);
		}
		Page<UserDto> pagifiedData = new PageImpl<UserDto>(userDtoList);
		return pagifiedData;
	}

	@Override
	public Page<UserDto> findByGender(Gender gender, Integer minpage, Integer maxpage, String sortBy) {
		Pageable pageRequest = PageRequest.of(minpage, maxpage, Sort.by(sortBy));
		Page<UserEntity> user = userRepository.findByGender(gender, pageRequest);
		List<UserDto> userDtoList = new ArrayList<>();
		for (UserEntity u : user) {
			UserDto userDto = UserDto.builder().id(u.getId()).firstName(u.getFirstName()).middleName(u.getMiddleName())
					.lastName(u.getLastName()).gender(u.getGender()).address(u.getAddress())
					.phoneNumber(u.getPhoneNumber()).email(u.getEmail()).build();

			userDtoList.add(userDto);
		}
		Page<UserDto> pagifiedData = new PageImpl<UserDto>(userDtoList);
		return pagifiedData;
	}

	@Override
	public UserDto getUserById(String id) {
		UserEntity userEntity = userRepository.findById(id).get();
		return UserDto.builder().id(userEntity.getId()).firstName(userEntity.getFirstName())
				.middleName(userEntity.getMiddleName()).lastName(userEntity.getLastName())
				.gender(userEntity.getGender()).address(userEntity.getAddress())
				.phoneNumber(userEntity.getPhoneNumber()).email(userEntity.getEmail()).build();
	}

	@Override
	public UserDto saveUser(UserDto user) {
		UserEntity userEntity = UserEntity.builder().id(user.getId()).firstName(user.getFirstName())
				.middleName(user.getMiddleName()).lastName(user.getLastName()).gender(user.getGender())
				.address(user.getAddress()).phoneNumber(user.getPhoneNumber()).email(user.getEmail()).build();
		userEntity = userRepository.save(userEntity);
		user.setId(userEntity.getId());
		return user;

	}

	@Override
	public UserDto updateUser(String id, UserDto user) {
		UserEntity userEntity = UserEntity.builder().id(id).firstName(user.getFirstName())
				.middleName(user.getMiddleName()).lastName(user.getLastName()).gender(user.getGender())
				.address(user.getAddress()).phoneNumber(user.getPhoneNumber()).email(user.getEmail()).build();
		userEntity = userRepository.save(userEntity);
		user.setId(userEntity.getId());
		return user;
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteById(id);

	}
}
