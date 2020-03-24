package com.project.portal.rest.dto;

import lombok.Data;

@Data
public class UserDto {

    private String username, password, firstName, lastName, email, createdDate;
}
