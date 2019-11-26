package com.jelg.socialnetwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jelg.socialnetwork.models.Post;
import com.jelg.socialnetwork.models.User;
import com.jelg.socialnetwork.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post save(Post post) {
		return repository.save(post);
	}
	
	public List<Post> findAllByUserAuthorId(String userId) {
		return repository.findAllByUserAuthor(new User(userId));
	}

}
