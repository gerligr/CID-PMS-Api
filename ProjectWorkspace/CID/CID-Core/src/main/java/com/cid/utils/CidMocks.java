package com.cid.utils;

import com.cid.beans.UserDto;

public class CidMocks {

	public static UserDto mockUser(){
		UserDto mock = new UserDto();		
		mock.setDepartmentId(L1);
		mock.setTeamId(L3);
		mock.setRoleId(L2);
		mock.setFirstname("Mari");
		mock.setLastname("Murumari");
		mock.setUsername("mari.murumari@cid.com");
		mock.setPassword("murumari1234");
		return mock;
	}		
	
	public static UserDto mockUser2(){
		UserDto mock = new UserDto();		
		mock.setDepartmentId(L1);
		mock.setTeamId(L3);
		mock.setRoleId(L2);
		mock.setFirstname("Mikk");
		mock.setLastname("Muru");
		mock.setUsername("mikk.muru@cid.com");
		mock.setPassword("muru1234");
		return mock;
	}	
}