package com.cid.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "role_id")
    private Long id;
	
	private String name;
	
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, mappedBy="role")
	private List<User> user = new ArrayList<>();

}
