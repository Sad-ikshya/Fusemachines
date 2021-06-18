package com.fuse.techBlog.entities;

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
@Document(collection = "reactions")
@ToString
@Builder
@Getter
@Setter
public class ReactionEntity {
	@Id
	private String id;
	private ReactionType reactionType;
	private UserEntity user;

}
