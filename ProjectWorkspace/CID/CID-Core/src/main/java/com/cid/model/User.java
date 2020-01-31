package com.cid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Data;


@Data
@Entity
@NamedQueries({
	@NamedQuery(
			name = "User_ByTeamId",
			query = "from User where teamId = :teamId"
			),
	@NamedQuery(
			name= "Users",
			query = "from User"
			)
})
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
	//private List<User> userList = new ArrayList();
		 
}
