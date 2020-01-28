package com.cid.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class User {
	private Long id;
	private Long departmentId;
	private Long teamId;
	private Long roleId;
	private String firstname;
	private String lastname;
	private String username;
	private String password;	
	private List<User> userList = new ArrayList();
		 
}
