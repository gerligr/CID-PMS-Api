package com.cid.utils;

import com.cid.model.User;

public class CidMocks {

	public static User mockUser(){
		User mock = new User();		
		mock.setDepartmentId(1L);
		mock.setTeamId(3L);
		mock.setRoleId(2L);
		mock.setFirstname("Mari");
		mock.setLastname("Storm");
		mock.setUsername("mari.storm@cid.com");
		mock.setPassword("storm1234");
		return mock;
	}		
	
	public static User mockUser2(){
		User mock = new User();	
		mock.setId(7L);
		mock.setDepartmentId(2L);
		mock.setTeamId(2L);
		mock.setRoleId(3L);
		mock.setFirstname("Peeter");
		mock.setLastname("Suslik");
		mock.setUsername("peeter.suslik@cid.com");
		mock.setPassword("suslik1234");
		return mock;
	}

	public static User mockUser3() {
		User mock = new User();	
		mock.setId(51L);
		mock.setDepartmentId(1L);
		mock.setTeamId(3L);
		mock.setRoleId(2L);
		mock.setFirstname("Liina");
		mock.setLastname("Juba");
		mock.setUsername("liina.Juba@cid.com");
		mock.setPassword("juba1234");
		return mock;
	}	
}