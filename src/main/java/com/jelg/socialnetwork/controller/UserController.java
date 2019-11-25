package com.jelg.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jelg.socialnetwork.models.User;
import com.jelg.socialnetwork.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(path = "/user", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> create(@RequestBody User user) {
		service.save(user);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.build();
	}

	@RequestMapping(path = "/user", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public ResponseEntity<List<User>> findAll() {
		List<User> users = service.findAll();
		return ResponseEntity
				.ok(users);
	}

}