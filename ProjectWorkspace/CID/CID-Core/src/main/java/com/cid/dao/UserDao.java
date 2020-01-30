package com.cid.dao;

import java.util.List;

import com.cid.beans.UserDto;
import com.cid.model.User;

public interface UserDao {
	
	public Long createUser(User userDto);	
	
	public User findById(Long id);
	
	public List<User> findByTeamId(Long teamId);
	
	public void deleteUser(User updatedUser);
	
	public void updateUser(User updatedUser);

	public List<User> findUsersWithSales();
	
	public List<User> loadAllUsers();
	
}
