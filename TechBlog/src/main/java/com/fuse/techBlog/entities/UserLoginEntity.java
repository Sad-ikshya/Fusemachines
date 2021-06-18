package com.fuse.techBlog.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "usersLogin")
@ToString
@Builder
@Getter
@Setter
public class UserLoginEntity {
	private String userId;
	private String username;
	private String password;

}
