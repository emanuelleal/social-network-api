package com.jelg.socialnetwork.models.basic;

import java.util.Date;

public interface BasicEntity {
	
	String getId();
	
	Date getCreatedAt();
	
	Date getLastModifiedDate();

}
