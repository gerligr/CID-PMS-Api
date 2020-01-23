package com.cid.utils;

import com.cid.beans.UserDto;

public class CidMocks {

	public static UserDto mockUser(){
		UserDto mock = new UserDto();		
		mock.setDepartmentId(1);
		mock.setTeamId(3);
		mock.setRoleId(2);
		mock.setFirstname("Mikk");
		mock.setLastname("Muru");
		mock.setUsername("mikk.muru@cid.com");
		mock.setPassword("muru1234");
		return mock;
	}		
	
	public static UserDto mockUser2(){
		UserDto mock = new UserDto();		
		mock.setDepartmentId(2);
		mock.setTeamId(2);
		mock.setRoleId(3);
		mock.setFirstname("Piret");
		mock.setLastname("Maa");
		mock.setUsername("piret.Maa@cid.com");
		mock.setPassword("maa1234");
		return mock;
	}	
}
