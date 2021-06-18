package com.fuse.techBlog.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuse.techBlog.dtos.FeedDto;
import com.fuse.techBlog.dtos.ReactionDto;
import com.fuse.techBlog.entities.FeedEntity;
import com.fuse.techBlog.repositories.FeedRepository;
import com.fuse.techBlog.services.FeedService;
import com.fuse.techBlog.services.ReactionService;

@Service
public class FeedServiceImplementation implements FeedService {
	@Autowired
	private FeedRepository feedRepository;
	@Autowired
	private ReactionService reactionService;

	@Override
	public List<FeedDto> fetchAllFeeds() {
		List<FeedEntity> feeds = feedRepository.findAll();
		List<FeedDto> feedDtoList = new ArrayList<>();
		for (FeedEntity f : feeds) {
			List<ReactionDto> reactions = new ArrayList<>();
			for (String reactionId : f.getReactions()) {
				ReactionDto react = reactionService.getReactionById(reactionId);
				reactions.add(react);
			}
			FeedDto feedDto = FeedDto.builder().id(f.getId()).title(f.getTitle()).description(f.getDescription())
					.images(f.getImages()).createdOn(f.getCreatedOn()).reactions(reactions).build();

			feedDtoList.add(feedDto);
		}
		return feedDtoList;
	}

	@Override
	public FeedDto postFeed(FeedDto feed) {
		FeedEntity feedEntity = FeedEntity.builder().id(feed.getId()).title(feed.getTitle())
				.description(feed.getDescription()).reactions(null).images(feed.getImages())
				.createdOn(feed.getCreatedOn()).build();

		feedEntity = feedRepository.save(feedEntity);
		feed.setId(feedEntity.getId());
		return feed;
	}

	@Override
	public FeedDto updateFeed(String id, FeedDto feed) {
		List<ReactionDto> reactions = feed.getReactions();
		List<String> reactionIds = new ArrayList<>();
		for (ReactionDto reaction : reactions) {
			String reactionId = reaction.getId();
			reactionIds.add(reactionId);
		}
		FeedEntity feedEntity = FeedEntity.builder().id(id).title(feed.getTitle()).description(feed.getDescription())
				.images(feed.getImages()).reactions(reactionIds).createdOn(feed.getCreatedOn()).build();

		feedEntity = feedRepository.save(feedEntity);
		feed.setId(feedEntity.getId());
		return feed;
	}

	@Override
	public FeedDto getPostById(String id) {
		FeedEntity feed = feedRepository.findById(id).get();
		List<ReactionDto> reactions = new ArrayList<>();
		for (String reactionId : feed.getReactions()) {
			ReactionDto react = reactionService.getReactionById(reactionId);
			reactions.add(react);
		}
		return FeedDto.builder().id(feed.getId()).title(feed.getTitle()).description(feed.getDescription())
				.images(feed.getImages()).createdOn(feed.getCreatedOn()).reactions(reactions).build();

	}

	@Override
	public void deleteFeed(String id) {
		feedRepository.deleteById(id);

	}

}
