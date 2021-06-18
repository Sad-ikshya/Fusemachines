package com.fuse.techBlog.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuse.techBlog.dtos.ReactionDto;
import com.fuse.techBlog.dtos.UserDto;
import com.fuse.techBlog.entities.ReactionEntity;
import com.fuse.techBlog.entities.UserEntity;
import com.fuse.techBlog.repositories.ReactionRepository;
import com.fuse.techBlog.services.ReactionService;

@Service
public class ReactionServiceImplementation implements ReactionService {
	@Autowired
	private ReactionRepository reactionRepository;

	@Override
	public ReactionDto createReaction(ReactionDto reaction) {
		UserEntity user = UserEntity.builder().id(reaction.getUser().getId()).build();
		ReactionEntity reactionEntity = ReactionEntity.builder().id(reaction.getId())
				.reactionType(reaction.getReactionType()).user(user).build();

		reactionEntity = reactionRepository.save(reactionEntity);
		reaction.setId(reactionEntity.getId());
		return reaction;
	}

	@Override
	public ReactionDto updateReaction(String id, ReactionDto reaction) {
		UserEntity user = UserEntity.builder().id(reaction.getUser().getId()).build();
		ReactionEntity reactionEntity = ReactionEntity.builder().id(id).reactionType(reaction.getReactionType())
				.user(user).build();

		reactionEntity = reactionRepository.save(reactionEntity);
		reaction.setId(reactionEntity.getId());
		return reaction;
	}

	@Override
	public ReactionDto getReactionById(String id) {
		ReactionEntity reaction = reactionRepository.findById(id).get();
		UserDto user = UserDto.builder().id(reaction.getUser().getId()).build();
		return ReactionDto.builder().id(reaction.getId()).reactionType(reaction.getReactionType()).user(user).build();
	}

}
