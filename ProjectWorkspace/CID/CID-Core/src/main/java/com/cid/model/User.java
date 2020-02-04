package com.cid.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="department_id")
	private Long departmentId;
	
	@Column(name="team_id")
	private Long teamId;
	
	@Column(name="role_id")
	private Long roleId;
	
	private String firstname;
	private String lastname;
	private String username;
	private String password;	
	
			 
}
