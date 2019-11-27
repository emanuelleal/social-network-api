package com.jelg.socialnetwork.post;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jelg.socialnetwork.user.User;

public interface PostRepository extends MongoRepository<Post, String>{

	List<Post> findAllByUserAuthor(User user);
	
}
