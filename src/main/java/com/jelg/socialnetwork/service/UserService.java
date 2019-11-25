package com.jelg.socialnetwork.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jelg.socialnetwork.models.User;
import com.jelg.socialnetwork.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User save(User user) {
		return repository.save(user);
	}
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public Optional<User> findById(String id) {
		return repository.findById(id);
	}

}
