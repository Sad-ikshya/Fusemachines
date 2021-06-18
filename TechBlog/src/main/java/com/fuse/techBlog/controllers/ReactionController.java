package com.fuse.techBlog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuse.techBlog.dtos.ReactionDto;
import com.fuse.techBlog.services.ReactionService;

@RestController
@RequestMapping("/reactions")
public class ReactionController {
	@Autowired
	private ReactionService reactionService;

	@PostMapping("/")
	public ResponseEntity<ReactionDto> createReaction(@RequestBody ReactionDto reaction) {
		return new ResponseEntity<ReactionDto>(reactionService.createReaction(reaction), HttpStatus.CREATED);
	}

	@PutMapping("/")
	public ResponseEntity<ReactionDto> updateReaction(@PathVariable String id, @RequestBody ReactionDto reaction) {
		return new ResponseEntity<ReactionDto>(reactionService.updateReaction(id, reaction), HttpStatus.OK);
	}
}
