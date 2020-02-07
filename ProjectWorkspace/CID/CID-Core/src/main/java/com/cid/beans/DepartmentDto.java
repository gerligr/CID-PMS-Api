package com.cid.beans;

import java.util.ArrayList;
import java.util.List;

import com.cid.model.User;

import lombok.Data;

@Data
public class DepartmentDto {
	
	private Long id;
	private String name;
	
	private List<User> user = new ArrayList<>();
	
}
