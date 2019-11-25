package com.jelg.socialnetwork.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jelg.socialnetwork.models.User;

public interface UserRepository extends MongoRepository<User, String>{

}
