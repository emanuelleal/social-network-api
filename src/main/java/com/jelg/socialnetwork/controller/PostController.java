package com.jelg.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jelg.socialnetwork.models.Post;
import com.jelg.socialnetwork.models.User;
import com.jelg.socialnetwork.service.PostService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
public class PostController {
	
	@Autowired
	private PostService service;
	
	@ApiOperation(value = "Update User")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "Title", dataType = "string", paramType = "body"),
            @ApiImplicitParam(name = "subtitle", value = "Subtitle", dataType = "string", paramType = "body")
    })
	@RequestMapping(value = "/posts", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> create(@RequestBody Post post, @RequestHeader("userId") String userId) {
		post.setUserAuthor(new User(userId));
		service.save(post);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public ResponseEntity<List<Post>> findAllByUserId(@RequestParam("userId") String userId) {
		List<Post> posts = service.findAllByUserAuthorId(userId);
		return ResponseEntity.ok(posts);
	}
	
	

}
