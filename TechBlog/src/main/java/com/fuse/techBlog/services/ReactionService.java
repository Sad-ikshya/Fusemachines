package com.fuse.techBlog.services;

import com.fuse.techBlog.dtos.ReactionDto;

public interface ReactionService {
	public ReactionDto createReaction(ReactionDto reaction);

	public ReactionDto updateReaction(String id, ReactionDto reaction);

	public ReactionDto getReactionById(String id);

}
