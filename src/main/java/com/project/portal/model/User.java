package com.project.portal.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor ;

@Data
@NoArgsConstructor
@AllArgsConstructor 
public class User {

	private String id, username, password, firstName, lastName, email, createdDate;
	
}
