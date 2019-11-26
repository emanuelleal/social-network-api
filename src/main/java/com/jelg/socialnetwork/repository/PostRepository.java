package com.jelg.socialnetwork.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jelg.socialnetwork.models.Post;
import com.jelg.socialnetwork.models.User;

public interface PostRepository extends MongoRepository<Post, String>{

	List<Post> findAllByUserAuthor(User user);
	
}
