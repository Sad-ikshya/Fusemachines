package com.fuse.techBlog.dtos;

import java.util.Date;
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
public class FeedDto {
	private String id;
	private String title;
	private String description;
	private List<String> images;
	private Date createdOn;
	private List<ReactionDto> reactions;
}
