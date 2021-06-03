package com.fuse.financeManagement.implementations;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fuse.financeManagement.exceptionHandling.UserNotFoundException;
import com.fuse.financeManagement.models.User;
import com.fuse.financeManagement.services.UserService;

@Service
public class UserServiceImplemenation implements UserService {
	private List<User> users;

	public UserServiceImplemenation() {
		users = new ArrayList<User>();
	}

	@Override
	public List<User> getUsers() {
		return users;
	}

	@Override
	public User createUser(User user) {
		users.add(user);
		return user;
	}

	@Override
	public User getUserById(BigInteger id) {
		for (User u : users) {
			if (u.getId().equals(id)) {
				return u;
			}
		}
		throw new UserNotFoundException();
	}

	@Override
	public User updateUser(BigInteger id, User updatedUser) {
		User usr = this.getUserById(id);
		users.set(users.indexOf(usr), updatedUser);
		return updatedUser;
	}

	@Override
	public void deleteuser(BigInteger id) {
		User u = this.getUserById(id);
		users.remove(u);
	}

}
