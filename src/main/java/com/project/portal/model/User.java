package com.project.portal.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor ;

@Data
@NoArgsConstructor
@AllArgsConstructor 
public class User {

	private String id;

	private String username;

	private String password;

	private String firstName;

	private String lastName;

	private String email;

	private String createdDate;
	
}
