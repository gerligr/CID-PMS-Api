package com.cid.beans;

import java.util.ArrayList;
import java.util.List;

import com.cid.model.User;

import lombok.Data;

@Data
public class RoleDto {
	
	private long id;
	private String name;	
	
	private List<User> user = new ArrayList<>();
	
}
