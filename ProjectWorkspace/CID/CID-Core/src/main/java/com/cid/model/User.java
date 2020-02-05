package com.cid.model;

import lombok.*;

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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "department_id", referencedColumnName = "id")
	private Department department;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="team_id", referencedColumnName = "id")
	private Team team;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="role_id", referencedColumnName = "id")
	private Role role;
	
	
	
			 
}
