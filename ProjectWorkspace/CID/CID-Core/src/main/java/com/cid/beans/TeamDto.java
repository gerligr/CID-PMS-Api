package com.cid.beans;

import java.util.ArrayList;
import java.util.List;

import com.cid.model.User;

import lombok.Data;

@Data
public class TeamDto {
	
	private Long teamId;
	private String name;	
	
	private List<User> user = new ArrayList<>();
	
}
