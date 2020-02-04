package com.cid.beans;

import lombok.Data;

@Data
public class UserDto {
	private Long id;
	private Long departmentId;
	private Long teamId;
	private Long roleId;
	private String firstname;
	private String lastname;
	private String username;
	private String password;	
	
	
}

