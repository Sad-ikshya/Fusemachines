package com.fuse.techBlog.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class UserLoginDto {
	private String userId;
	private String username;
	private String password;

}
