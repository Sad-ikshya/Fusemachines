package com.fuse.techBlog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuse.techBlog.dtos.FeedDto;
import com.fuse.techBlog.services.FeedService;

@RestController
@RequestMapping("/feeds")
public class FeedController {
	@Autowired
	private FeedService feedService;

	@GetMapping("/")
	public ResponseEntity<List<FeedDto>> getAllFeeds() {
		return new ResponseEntity<List<FeedDto>>(feedService.fetchAllFeeds(), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<FeedDto> saveFeed(@RequestBody FeedDto feed) {
		return new ResponseEntity<FeedDto>(feedService.postFeed(feed), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<FeedDto> updateFeed(@PathVariable String id, @RequestBody FeedDto feed) {
		return new ResponseEntity<FeedDto>(feedService.updateFeed(id, feed), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FeedDto> getFeedById(@PathVariable String id) {
		return new ResponseEntity<FeedDto>(feedService.getPostById(id), HttpStatus.FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deletePost(@PathVariable String id) {
		feedService.deleteFeed(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}
