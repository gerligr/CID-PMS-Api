package com.cid.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Role {
	
	@Id
    @GeneratedValue
    private Long roleId;
	
	private String name;
	
	@OneToOne(mappedBy = "role")
	private User user;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE}, mappedBy="role")
	private List<User> users = new ArrayList<>();

}