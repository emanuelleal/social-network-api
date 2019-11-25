package com.jelg.socialnetwork.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "user")
public class User {
	
	@Id
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private String password;

}
