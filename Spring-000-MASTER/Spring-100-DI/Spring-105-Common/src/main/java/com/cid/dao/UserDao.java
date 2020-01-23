package com.cid.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import com.cid.beans.UserDto;
import com.cid.model.UserModel;

public interface UserDao {
	
	void createUser(UserDto newUser);
		
	void loadAllUsers();
	
	UserDto findById(int id);
	
	ArrayList<UserModel> findByTeamId(int teamId);
	
	void deleteUser(int id);
	
	void updateUser(int id, UserDto userToUpdate);	

}
