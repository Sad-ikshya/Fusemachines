package com.fuse.oauth2Practice;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fuse.oauth2Practice.entities.User;
import com.fuse.oauth2Practice.repositories.UserRepository;

@SpringBootApplication
public class Oauth2PracticeProjectApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Lazy
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(Oauth2PracticeProjectApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		if (this.userRepository.findByUsername("sadikshya") == null) {
			User user = new User("Sadikshya Shrestha", "sadikshya", passwordEncoder.encode("sadik23"), Arrays.asList("ADMIN"));

			this.userRepository.save(user);
		}
	}

}
