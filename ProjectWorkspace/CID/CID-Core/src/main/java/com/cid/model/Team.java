package com.cid.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Team {
	
	@Id
    @GeneratedValue
    private Long teamId;
	
	private String name;
	
	@OneToOne(mappedBy = "team")
	private User user;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
	private Department department;*/

}
