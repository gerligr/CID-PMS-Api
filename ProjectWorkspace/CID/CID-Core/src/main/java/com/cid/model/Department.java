package com.cid.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long departmentId;
		
	private String name;
	
	@OneToOne(mappedBy = "department", cascade = CascadeType.ALL)
	private User user;
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	private List<Team> teams = new ArrayList<>();*/

}
