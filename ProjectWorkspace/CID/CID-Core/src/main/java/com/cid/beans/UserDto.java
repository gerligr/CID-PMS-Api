package com.cid.beans;

import com.cid.model.Team;

import lombok.Data;

@Data
public class UserDto {
	private Long id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	
	private TeamDto team;
	private RoleDto role;
	
	 
}

