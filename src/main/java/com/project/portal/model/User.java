package com.project.portal.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor ;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String username, password, firstName, lastName, email, createdDate;
	
}
