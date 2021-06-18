package com.fuse.techBlog.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
@ToString
@Builder
@Getter
@Setter
public class UserEntity {
	@Id
	private String id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String password;
	private String address;
	private String phoneNumber;
	private List<String> posts;

}
