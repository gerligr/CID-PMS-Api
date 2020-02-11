package com.cid.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cid.beans.TeamDto;

import lombok.Data;

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
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "team_id")
	private Team team;

	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "role_id")
	private Role role;	
	
	/*
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Meeting> meetings = new ArrayList<>();		
	*/
			 
}
