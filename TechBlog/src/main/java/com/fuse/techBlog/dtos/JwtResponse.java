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
public class JwtResponse implements Serializable {
	private static final long serialVersionUID = -8091879091924046844L;

	private String jwttoken;
}