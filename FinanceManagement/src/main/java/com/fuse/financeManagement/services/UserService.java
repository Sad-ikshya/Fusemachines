package com.fuse.financeManagement.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fuse.financeManagement.models.User;

@Service
public interface UserService {
	public List<User> getUsers(int index, int dataLimit);

	public User createUser(User user);

	public User getUserById(BigInteger id);

	public User updateUser(BigInteger id, User user);

	public void deleteuser(BigInteger id);

}
