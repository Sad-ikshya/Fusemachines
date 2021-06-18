package com.fuse.techBlog.services;

import java.util.List;

import com.fuse.techBlog.dtos.FeedDto;

public interface FeedService {
	public List<FeedDto> fetchAllFeeds();

	public FeedDto postFeed(FeedDto feed);

	public FeedDto updateFeed(String id, FeedDto feed);

	public FeedDto getPostById(String id);

	public void deleteFeed(String id);

}
