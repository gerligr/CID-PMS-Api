package com.cid.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long departmentId;
		
	private String name;
	
	@OneToOne(mappedBy = "department")
	private User user;
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	private List<Team> teams = new ArrayList<>();*/

}
