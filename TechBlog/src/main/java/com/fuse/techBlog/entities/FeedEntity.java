package com.fuse.techBlog.entities;

import java.util.Date;
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
@Document(collection = "feeds")
@ToString
@Builder
@Getter
@Setter
public class FeedEntity {
	@Id
	private String id;
	private String title;
	private String description;
	private List<String> images;
	private Date createdOn;
	private List<String> reactions;

}
