package com.fuse.techBlog.dtos;

import com.fuse.techBlog.entities.ReactionType;

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
public class ReactionDto {
	private String id;
	private ReactionType reactionType;
	private UserDto user;

}
