package com.fuse.oauthClient.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuse.oauthClient.entities.Provider;
import com.fuse.oauthClient.entities.UserEntity;
import com.fuse.oauthClient.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	 
    public void processOAuthPostLogin(String username) {
        UserEntity existUser = repo.getByEmail(username);
         
        if (existUser == null) {
            UserEntity newUser = new UserEntity();
            newUser.setEmail(username);
            newUser.setProvider(Provider.GOOGLE);
             
            repo.save(newUser);        
        }
         
    }
}
