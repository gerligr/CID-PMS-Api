package com.cid.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Data
@Entity
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
	
	private String firstname;
	private String lastname;
	private String username;
	private String password;		
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
	private Department departmentId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
	private Team teamId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
	private Role roleId;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Meeting> meetings = new ArrayList<>();

	
	
	
	
			 
}
