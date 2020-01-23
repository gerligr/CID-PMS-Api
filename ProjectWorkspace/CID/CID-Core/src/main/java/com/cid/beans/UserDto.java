package com.cid.beans;

import lombok.Data;

@Data
public class UserDto {
	private int id;
	private int departmentId;
	private int teamId;
	private int roleId;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
}

