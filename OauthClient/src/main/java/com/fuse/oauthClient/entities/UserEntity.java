package com.fuse.oauthClient.entities;



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
	private String email;
	private String password;
	private Provider provider;

}
