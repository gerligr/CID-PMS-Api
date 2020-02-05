package com.cid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Team {
	
	@Id
	@Column(name = "id")
	private Long teamId;
	
	private String name;
	
	@Column(name = "department_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Department department;

}
