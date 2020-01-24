package com.cid.dao;

import java.util.List;

import com.cid.beans.UserDto;
import com.cid.model.User;

public interface UserDao {
	
	void createUser(UserDto userDto);
		
	List<User> loadAllUsers();
	
	User findById(int id);
	
	List<User> findByTeamId(int teamId);
	
	void deleteUser(int id);
	
	void updateUser(int id, UserDto userDto);			

}
