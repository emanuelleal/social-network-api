package com.jelg.socialnetwork.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jelg.socialnetwork.user.User;

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
