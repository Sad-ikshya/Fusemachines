package com.fuse.techBlog.dtos;

import java.util.List;

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
public class UserDto {
	private String id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String password;
	private String address;
	private String phoneNumber;
	private List<FeedDto> posts;

}
