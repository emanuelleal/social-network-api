package com.jelg.socialnetwork.post;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.jelg.socialnetwork.models.basic.BasicEntity;
import com.jelg.socialnetwork.user.User;

import lombok.Data;

@Data
@Document(collection = "post")
public class Post implements BasicEntity {

	@Id
	private String id;

	@NotBlank
	private String title;

	@NotBlank
	private String subtitle;

	@DBRef
	private User userAuthor;

	@CreatedDate
	private Date createdAt;

	@LastModifiedDate
	private Date lastModifiedDate;

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public Date getCreatedAt() {
		return this.createdAt;
	}

	@Override
	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

}
