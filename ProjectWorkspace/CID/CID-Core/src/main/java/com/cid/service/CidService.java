package com.cid.service;

import com.cid.beans.UserDto;

public interface CidService {
	
	void feature(UserDto user);
	
	void findUser(int id);
	
	void deleteUser(int id);
	
	void updateUser(int id, UserDto user);		

}
