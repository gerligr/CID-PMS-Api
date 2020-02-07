package com.cid.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.*;

@Data
@Entity
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
	
	private String firstname;
	private String lastname;
	private String username;
	private String password;		
	
	@OneToOne()
    @JoinColumn(name = "department_id")
	private Department department;
	/*
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
	private Team team;	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
	private Role role;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Meeting> meetings = new ArrayList<>();	
	
	*/
			 
}
