package com.jelg.socialnetwork.controller;
	
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jelg.socialnetwork.models.User;
import com.jelg.socialnetwork.service.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@ApiOperation(value = "Create a new User")
	@RequestMapping(path = "/users", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> create(@RequestBody User user) {
		service.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@ApiOperation(value = "Get All Users")
	@RequestMapping(path = "/users", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public ResponseEntity<List<User>> findAll() {
		List<User> users = service.findAll();
		return ResponseEntity.ok(users);
	}

	@ApiOperation(value = "Find User by id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Id", dataType = "string", paramType = "path")
    })
	@RequestMapping(path = "/users/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> findById(@PathVariable("id") String id) {
		Optional<User> userOptional = service.findById(id);

		if (!userOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}

		return ResponseEntity.ok(userOptional.get());
	}

	@ApiOperation(value = "Update User")
    @ApiImplicitParams({
    	    @ApiImplicitParam(name = "id", value = "Fist Name", dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "firstName", value = "Fist Name", dataType = "string", paramType = "body"),
            @ApiImplicitParam(name = "lastName", value = "Last Name", dataType = "string", paramType = "body"),
            @ApiImplicitParam(name = "age", value = "Age", dataType = "int", paramType = "body"),
            @ApiImplicitParam(name = "password", value = "Password", dataType = "string", paramType = "body")
    })
	@RequestMapping(path = "/users/{id}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody User user) {
		user.setId(id);
		User entity = service.save(user);

		return ResponseEntity.ok(entity);
	}

}
