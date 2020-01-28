package com.cid.utils;

import com.cid.beans.UserDto;

public class CidMocks {

	public static UserDto mockUser(){
		UserDto mock = new UserDto();		
		mock.setDepartmentId(1L);
		mock.setTeamId(3L);
		mock.setRoleId(2L);
		mock.setFirstname("Mirjam");
		mock.setLastname("Maja");
		mock.setUsername("mirjam.maja@cid.com");
		mock.setPassword("maja1234");
		return mock;
	}		
	
	public static UserDto mockUser2(){
		UserDto mock = new UserDto();		
		mock.setDepartmentId(1L);
		mock.setTeamId(3L);
		mock.setRoleId(2L);
		mock.setFirstname("Mikk");
		mock.setLastname("Muru");
		mock.setUsername("mikk.muru@cid.com");
		mock.setPassword("muru1234");
		return mock;
	}	
}