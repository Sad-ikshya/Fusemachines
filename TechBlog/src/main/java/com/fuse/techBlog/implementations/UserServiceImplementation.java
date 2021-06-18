package com.fuse.techBlog.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuse.techBlog.dtos.FeedDto;
import com.fuse.techBlog.dtos.UserDto;
import com.fuse.techBlog.entities.UserEntity;
import com.fuse.techBlog.repositories.UserRepository;
import com.fuse.techBlog.services.FeedService;
import com.fuse.techBlog.services.UserService;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FeedService feedService;

	@Override
	public List<UserDto> getAllUsers() {
		List<UserEntity> userEntity = userRepository.findAll();
		List<UserDto> userDtoList = new ArrayList<>();
		for (UserEntity user : userEntity) {

			UserDto userDto = UserDto.builder().id(user.getId()).firstName(user.getFirstName())
					.middleName(user.getMiddleName()).lastName(user.getFirstName()).email(user.getEmail())
					.address(user.getAddress()).phoneNumber(user.getPhoneNumber()).build();

			userDtoList.add(userDto);
		}
		return userDtoList;
	}

	@Override
	public UserDto saveUser(UserDto user) {
		try {
			System.out.println("Error====================>" + user.getFirstName());

			UserEntity userEntity = UserEntity.builder().id(user.getId()).firstName(user.getFirstName())
					.middleName(user.getMiddleName()).lastName(user.getFirstName()).email(user.getEmail())
					.address(user.getAddress()).phoneNumber(user.getPhoneNumber()).build();

			userEntity = userRepository.save(userEntity);
			user.setId(userEntity.getId());
			return user;
		} catch (Exception E) {
			System.out.println("Error====================>" + E.getLocalizedMessage());
			return new UserDto();
		}
	}

	@Override
	public UserDto getUserById(String id) {
		UserEntity userEntity = userRepository.findById(id).get();
		List<FeedDto> feeds = new ArrayList<>();
		if (!userEntity.getPosts().isEmpty()) {
			for (String postId : userEntity.getPosts()) {
				FeedDto feed = feedService.getPostById(postId);
				feeds.add(feed);
			}
		}
		return UserDto.builder().id(userEntity.getId()).firstName(userEntity.getFirstName())
				.middleName(userEntity.getMiddleName()).lastName(userEntity.getLastName()).email(userEntity.getEmail())
				.address(userEntity.getAddress()).phoneNumber(userEntity.getPhoneNumber()).posts(feeds).build();
	}

	@Override
	public UserDto updateUser(String id, UserDto user) {
		List<String> feeds = new ArrayList<>();
		for (FeedDto feed : user.getPosts()) {
			feeds.add(feed.getId());
		}
		UserEntity userEntity = UserEntity.builder().id(id).firstName(user.getFirstName())
				.middleName(user.getMiddleName()).lastName(user.getFirstName()).email(user.getEmail())
				.address(user.getAddress()).phoneNumber(user.getPhoneNumber()).posts(feeds).build();

		userEntity = userRepository.save(userEntity);
		user.setId(userEntity.getId());
		return user;
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteById(id);

	}

}
