package com.cid.beans;

import java.util.ArrayList;
import java.util.List;

import com.cid.model.Team;

import lombok.Data;

@Data
public class DepartmentDto {
	
	private long id;
	private String name;
	
	private List<Team> team = new ArrayList<>();
	
}
