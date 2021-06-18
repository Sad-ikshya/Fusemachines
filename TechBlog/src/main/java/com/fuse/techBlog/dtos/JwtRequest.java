package com.fuse.techBlog.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class JwtRequest implements Serializable {
	private static final long serialVersionUID = 5926468583005150707L;

	private String username;
	private String password;
}
