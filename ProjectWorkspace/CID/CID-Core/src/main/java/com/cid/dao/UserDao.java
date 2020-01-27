package com.cid.dao;

import java.util.List;

import com.cid.beans.UserDto;
import com.cid.model.User;

public interface UserDao {
	
	void createUser(UserDto userDto);
		
	List<User> loadAllUsers();
	
	User findById(Long id);
	
	List<User> findByTeamId(Long teamId);
	
	void deleteUser(Long id);
	
	void updateUser(Long id, UserDto userDto);			

}
